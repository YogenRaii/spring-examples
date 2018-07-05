package com.eprogrammerz.examples.rest.domains;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Address {

	@NotEmpty @NotNull
	private String street;
	
	@NotEmpty @NotNull
	private String city;
	
	@NotEmpty @NotNull @Size(min = 2, max = 2)
	private String state;
	
	@Pattern(regexp = "[1-9]\\d{4}")
	private String zip;
}
