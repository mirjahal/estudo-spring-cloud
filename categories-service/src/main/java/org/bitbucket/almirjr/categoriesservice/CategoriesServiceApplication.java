package org.bitbucket.almirjr.categoriesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CategoriesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoriesServiceApplication.class, args);
	}
}
