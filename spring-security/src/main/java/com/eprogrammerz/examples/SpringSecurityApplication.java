package com.eprogrammerz.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication
@EnableOAuth2Client
@EnableAuthorizationServer
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}
}
