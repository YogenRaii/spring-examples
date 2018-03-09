package com.company.dpt.metric.api.metricapi.exceptions;

import com.company.dpt.metric.api.metricapi.models.common.Error;
import lombok.Getter;
import org.springframework.validation.Errors;

@Getter
public class AlreadyExistsException extends BaseException {
    private final Error error;

    public AlreadyExistsException(String message, Error error) {
        super(message);
        this.error = error;
    }
}
