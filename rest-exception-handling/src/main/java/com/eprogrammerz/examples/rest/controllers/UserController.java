package com.eprogrammerz.examples.rest.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eprogrammerz.examples.rest.domains.User;
import com.eprogrammerz.examples.rest.exceptions.DataException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class UserController {
	
	@PostMapping(value = "/users")
	public ResponseEntity<?> createUser(@Valid @RequestBody User user, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			throw new DataException("Invalid Input", bindingResult);
		}
		log.info("Input user is: {}", user.toString());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
