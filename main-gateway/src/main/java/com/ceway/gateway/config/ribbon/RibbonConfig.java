package com.ceway.gateway.config.ribbon;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author 伍金亮
 * @version 自定义ribbon调用
 * @date 2020/5/3 6:08 下午
 */
@Component
public class RibbonConfig {

    @Bean
    public MainRestTemplate mainRestTemplate(DiscoveryClient discoveryClient){
        return new MainRestTemplate(discoveryClient);
    }
}
