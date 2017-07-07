package com.eprogrammerz.examples.validation.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eprogrammerz.examples.validation.models.Car;

/**
 * @author Yogen
 *
 */
@RestController
public class CarController {

	@PostMapping(value = "/cars")
	public ResponseEntity<?> createCar(@Valid @RequestBody Car car, BindingResult result) {
		if(result.hasErrors()) {
			final List<FieldError> fieldErrors = result.getFieldErrors();
			return new ResponseEntity<>(fieldErrors, HttpStatus.BAD_REQUEST);
		}
		System.out.println(car);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
