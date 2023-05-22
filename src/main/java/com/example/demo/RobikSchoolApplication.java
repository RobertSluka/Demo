package com.example.demo;

import com.example.demo.baeldung.ChatEndpoint;
import com.example.demo.baeldung.Message;
import jakarta.websocket.ContainerProvider;
import jakarta.websocket.Session;
import jakarta.websocket.WebSocketContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@SpringBootApplication(exclude = PropertyPlaceholderAutoConfiguration.class)
@EnableWebSocket
public class RobikSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobikSchoolApplication.class, args);

	}
}


