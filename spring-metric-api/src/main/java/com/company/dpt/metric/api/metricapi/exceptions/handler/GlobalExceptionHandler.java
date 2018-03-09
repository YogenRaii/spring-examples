package com.company.dpt.metric.api.metricapi.exceptions.handler;

import com.company.dpt.metric.api.metricapi.exceptions.AlreadyExistsException;
import com.company.dpt.metric.api.metricapi.exceptions.BaseException;
import com.company.dpt.metric.api.metricapi.exceptions.DataException;
import com.company.dpt.metric.api.metricapi.exceptions.NotFoundException;
import com.company.dpt.metric.api.metricapi.models.interfaces.ErrorResponse;
import com.company.dpt.metric.api.metricapi.models.common.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSourceAccessor messageSourceAccessor;

    @ExceptionHandler(DataException.class)
    public ResponseEntity<ErrorResponse> handleDataException(DataException exception) {
        final List<Error> errors = new ArrayList<>();
        final List<FieldError> fieldErrors = exception.getErrors().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            final Error error = new Error(fieldError.getCode(), fieldError.getField(), messageSourceAccessor.getMessage(fieldError));
            errors.add(error);
        }
        return new ResponseEntity<>(generateErrorResponse(HttpStatus.BAD_REQUEST.value(), exception, errors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException exception) {
        final List<Error> errors = new ArrayList<>();
        final Error error = exception.getError();
        if (error != null) {
            errors.add(error);
        }
        return new ResponseEntity<ErrorResponse>(generateErrorResponse(HttpStatus.NOT_FOUND.value(), exception, errors), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleAlreadyExistsException(AlreadyExistsException exception) {
        final List<Error> errors = new ArrayList<>();
        final Error error = exception.getError();
        if (error != null) {
            errors.add(error);
        }
        return new ResponseEntity<ErrorResponse>(generateErrorResponse(HttpStatus.CONFLICT.value(), exception, errors), HttpStatus.CONFLICT);
    }

    private ErrorResponse generateErrorResponse(int code, BaseException exception, List<Error> errors) {
        final ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(code);
        errorResponse.setDevelopersMessage(exception.getMessage());
        errorResponse.setErrors(errors);
        return errorResponse;
    }
}
