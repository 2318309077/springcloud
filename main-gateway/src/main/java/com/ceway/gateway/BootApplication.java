package com.ceway.gateway;

import com.ceway.gateway.config.filter.bo.RouteEntity;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

//@MapperScan(basePackages = {"com.ceway.attestation.mapper"}) //扫描mapper
@SpringBootApplication
@EnableEurekaClient 
public class BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

}
