package com.example.cinemaApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CinemaApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(CinemaApp1Application.class, args);
	}

}
