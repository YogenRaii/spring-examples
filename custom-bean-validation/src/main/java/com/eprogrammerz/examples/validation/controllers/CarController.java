package com.eprogrammerz.examples.validation.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eprogrammerz.examples.validation.config.MessageSourceConfig;
import com.eprogrammerz.examples.validation.models.Car;
import com.eprogrammerz.examples.validation.models.common.Error;

/**
 * @author Yogen
 *
 */
@RestController
public class CarController {

	@Autowired
	private MessageSourceAccessor messageSource;

	@PostMapping(value = "/cars")
	public ResponseEntity<?> createCar(@Valid @RequestBody Car car, BindingResult result) {
		if (result.hasErrors()) {
			final List<FieldError> fieldErrors = result.getFieldErrors();
			fieldErrors.stream().forEach(System.out::println);
			final List<Error> errors = fieldErrors.stream()
					.map(fe -> new Error(fe.getCode(), fe.getField(), messageSource.getMessage(fe)))
					.collect(Collectors.toList());
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		System.out.println(car);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
