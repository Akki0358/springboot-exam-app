package com.tka.onlineexamapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com")
public class OnlineexamapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineexamapplicationApplication.class, args);
	}

}
