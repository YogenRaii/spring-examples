package com.company.dpt.metric.api.metricapi.exceptions;

public abstract class BaseException extends RuntimeException {
    public BaseException(String message) {
        super(message);
    }
}
