package com.ceway.shardingjdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = "com.ceway.shardingjdbc.mapper") //扫描mapper
@ComponentScan(basePackages = "com")
@EnableConfigurationProperties
@EnableEurekaClient
public class BootApplication {

	public static void main(String[] args) {

		SpringApplication.run(BootApplication.class, args);
		System.out.println("000");
	}

}
