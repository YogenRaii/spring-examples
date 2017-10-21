/**
 * 
 */
package com.eprogrammerz.examples.validation.validators.enumValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.eprogrammerz.examples.validation.models.types.CaseMode;

/**
 * @author Yogen
 *
 */
public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {

    private CheckCase caseMode;

    @Override
    public void initialize(CheckCase constraintAnnotation) {
        this.caseMode = constraintAnnotation;
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
        if ( object == null ) {
            return true;
        }
        
        boolean result = false;
        
        Object[] enumValues = this.caseMode.enumClass().getEnumConstants();

        if(enumValues != null)
        {
            for(Object enumValue:enumValues)
            {
                if(object.equals(enumValue.toString()))
                {
                    result = true; 
                    break;
                }
            }
        }
         
        return result;
    }
}