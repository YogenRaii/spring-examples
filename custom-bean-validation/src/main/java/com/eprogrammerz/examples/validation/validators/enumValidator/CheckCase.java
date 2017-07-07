/**
 * 
 */
package com.eprogrammerz.examples.validation.validators.enumValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


import com.eprogrammerz.examples.validation.models.types.CaseMode;


/**
 * @author Yogen
 *
 */
@Documented
@Constraint(validatedBy = CheckCaseValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER,
		ElementType.CONSTRUCTOR })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckCase {
	String message() default "{org.hibernate.validator.referenceguide.chapter06.CheckCase." +
            "message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    CaseMode value();

    @Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        CheckCase[] value();
    }
}
