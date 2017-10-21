/**
 * 
 */
package com.eprogrammerz.examples.validation.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.eprogrammerz.examples.validation.validators.enumValidator.CheckCase;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.eprogrammerz.examples.validation.models.types.CaseMode;

/**
 * @author Yogen
 *
 */
@Getter
@Setter
@ToString
public class Car {
	@NotNull
    private String manufacturer;

    @NotNull
    @Size(min = 2, max = 14)
    @CheckCase(enumClass = CaseMode.class)
    private String licensePlate;

    @Min(2)
    private int seatCount;

}
