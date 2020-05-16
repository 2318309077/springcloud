package com.ceway.gateway.config.filter;

import com.ceway.gateway.config.filter.bo.RouteEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.RequestPath;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import javax.swing.event.AncestorEvent;
import java.net.InetSocketAddress;
import java.net.URI;

/**
 * @author 伍金亮
 * @version 拦截器进行token调验
 * @date 2020/4/30 9:40 上午
 */
@Slf4j
@Component
@EnableConfigurationProperties(RouteEntity.class)
public class TokenFilter implements GlobalFilter,Ordered, InitializingBean {

    @Autowired(required = false)
    private  RouteEntity routeEntity;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String requestPath =exchange.getRequest().getURI().getPath();
        log.info("UrlFilter开始............RequestPath==="+requestPath);
        //不拦截接口
        if(shoudSkip(requestPath)){

        }
        return chain.filter(exchange);
    }
    //接口匹配判断
    private boolean shoudSkip(String requestPath) {
        PathMatcher matcher = new AntPathMatcher();
        for(String skipPath:routeEntity.getShoudSkipUrl()) {
            if (matcher.match(skipPath, requestPath)) {
                return true;
            }
        }
            return false;
    }

    @Override
    public int getOrder() {
        return 0;
    }

    /**
     * 初始化获取认证中心公钥
     * 伍金亮
     */
    @Override
    public void afterPropertiesSet() throws Exception {

    }

}
