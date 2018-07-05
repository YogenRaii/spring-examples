package com.eprogrammerz.examples.rest.exceptions.handlers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.eprogrammerz.examples.rest.domains.ErrorResponse;
import com.eprogrammerz.examples.rest.domains.Error;
import com.eprogrammerz.examples.rest.exceptions.DataException;

import lombok.RequiredArgsConstructor;

@ControllerAdvice
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	private final MessageSourceAccessor messageSourceAccessor;
	
	@ExceptionHandler(DataException.class)
	public ResponseEntity<ErrorResponse> handleDataException(DataException exception) {
		final List<Error> errors = new ArrayList<>();
		final List<FieldError> fieldErrors = exception.getErrors().getFieldErrors();
		for(FieldError fieldError: fieldErrors) {
			final Error error = new Error();
			error.setErrorCode(fieldError.getCode());
			error.setField(fieldError.getField());
			error.setMessage(messageSourceAccessor.getMessage(fieldError));
			errors.add(error);
		}
		return new ResponseEntity<ErrorResponse>(generateErrorResponse(HttpStatus.BAD_REQUEST.value(), exception, errors), HttpStatus.BAD_REQUEST);
	}

	private ErrorResponse generateErrorResponse(int code, DataException exception, List<Error> errors) {
		final ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(code);
		errorResponse.setDevelopersMessage(exception.getMessage());
		errorResponse.setErrors(errors);
		return errorResponse;
	}
}
