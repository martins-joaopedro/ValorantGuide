package com.valorant.valorantguide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ValorantGuideApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValorantGuideApplication.class, args);
	}

}
