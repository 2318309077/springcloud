package com.ceway.gateway.config.filter.bo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedHashSet;

/**
 * @author 伍金亮
 * @version 1.0
 * @date 2020/5/3 2:43 下午
 */
@Data
@ConfigurationProperties(value = "main.gateway")

public class RouteEntity {

     private LinkedHashSet<String> shoudSkipUrl;
}
