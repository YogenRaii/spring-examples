package com.company.dpt.metric.api.metricapi.exceptions;

import lombok.Getter;
import org.springframework.validation.Errors;

@Getter
public class DataException extends BaseException {
    private final Errors errors;

    public DataException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }
}
