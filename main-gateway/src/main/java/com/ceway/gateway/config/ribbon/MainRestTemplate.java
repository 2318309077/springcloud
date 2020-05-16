package com.ceway.gateway.config.ribbon;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.web.client.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;

/**
 * @author 伍金亮
 * @version 1.0
 * @date 2020/5/3 10:41 下午
 */
@Slf4j
public class MainRestTemplate extends RestTemplate {
    //统一的注册中心信息获取
    private DiscoveryClient discoveryClient;

    public MainRestTemplate(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @Nullable
    protected <T> T doExecute(URI url, @Nullable HttpMethod method, @Nullable RequestCallback requestCallback, @Nullable ResponseExtractor<T> responseExtractor) throws RestClientException {
        Assert.notNull(url, "URI is required");
        Assert.notNull(method, "HttpMethod is required");
        ClientHttpResponse response = null;

        Object var14;
        try {
            log.info("请求的路径为{}",url);
            url = replaceUrl(url);
            log.info("替换请求的路径为{}",url);
            ClientHttpRequest request = this.createRequest(url, method);
            if (requestCallback != null) {
                requestCallback.doWithRequest(request);
            }

            response = request.execute();
            this.handleResponse(url, method, response);
            var14 = responseExtractor != null ? responseExtractor.extractData(response) : null;
        } catch (IOException var12) {
            String resource = url.toString();
            String query = url.getRawQuery();
            resource = query != null ? resource.substring(0, resource.indexOf(63)) : resource;
            throw new ResourceAccessException("I/O error on " + method.name() + " request for \"" + resource + "\": " + var12.getMessage(), var12);
        } finally {
            if (response != null) {
                response.close();
            }

        }
        return (T) var14;
    }

    /**
     * 去微服务拉取对应的ip
     * @param url
     * @return
     */
    private URI replaceUrl(URI url) {
        //获取服务名称
        String ServiceName = url.getHost();
        log.info("当前微服务名称{}",ServiceName);

        //解析请求的path
        String repPath = url.getPath();
        log.info("当前微服务path名称{}",repPath);

        //通过对应的serverName获取注册中心对应的ip
        List<ServiceInstance> serviceInstance = discoveryClient.getInstances(ServiceName);
        if(serviceInstance.isEmpty()){
               throw  new RuntimeException("没有对应的微服务"+ServiceName);
        }

        String chooseTargetIp = ChooseTargetIp(serviceInstance);

        String sourcePath = chooseTargetIp + repPath;

        try{
             return new URI(sourcePath);
        }catch (URISyntaxException e){
            log.error("构建ip{}出现异常",sourcePath);
        }
        return url;
    }

    /**
     * 对返回的ip进行选取
     * 伍金亮
     * @param serviceInstanceList
     * @return
     */
    private String ChooseTargetIp(List<ServiceInstance> serviceInstanceList) {
        //随机选取ip
         Random random = new Random();
         Integer randomIndex = random.nextInt(serviceInstanceList.size());
         String serviceIp = serviceInstanceList.get(randomIndex).getUri().toString();
         log.info("随机选取ip为",serviceIp);
         return serviceIp;
    }

}
