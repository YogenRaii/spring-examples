package com.company.dpt.metric.api.metricapi.exceptions;

import com.company.dpt.metric.api.metricapi.models.common.Error;
import lombok.Getter;

@Getter
public class NotFoundException extends BaseException {
    private final Error error;

    public NotFoundException(String message, Error error) {
        super(message);
        this.error = error;
    }
}
