package com.eprogrammerz.examples.rest.domains;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
	@NotEmpty @NotNull
	private String firstName;
	
	@NotEmpty @NotNull
	private String lastName;
	
	@Min(1)
	private int age;
	
	@Past
	private Date dateOfBirth;
	
	@Valid
	private Address address;
}
