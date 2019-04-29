package com.lovo.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class BootMain {
 
	public static void main(String[] args) {
		
		//springboot入口
		SpringApplication.run(BootMain.class, args);
	}
}
