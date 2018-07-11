package com.eprogrammerz.examples.spring.getToken;

import com.eprogrammerz.examples.spring.getToken.clients.RemoteServiceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@SpringBootApplication
public class GetTokenApplication {
	@Autowired
	private RemoteServiceClient serviceClient;

	public static void main(String[] args) {
		SpringApplication.run(GetTokenApplication.class, args);
	}

	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> login(@RequestBody String string) throws Exception {

		Object response = this.serviceClient.authenticateToIcon(string);

		log.info("Cookies: {}", response);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
