package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;


@SpringBootApplication(exclude = PropertyPlaceholderAutoConfiguration.class)
@EnableWebSocket
public class RobikSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobikSchoolApplication.class, args);
	}
}
