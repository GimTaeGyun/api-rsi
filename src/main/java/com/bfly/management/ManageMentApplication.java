package com.bfly.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = "com.bfly")
@EnableCaching
@EnableDiscoveryClient
public class ManageMentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManageMentApplication.class, args);
	}

}
