package com.marcoagpegoraro.asyncdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AsyncDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncDemoApplication.class, args);
	}

}
