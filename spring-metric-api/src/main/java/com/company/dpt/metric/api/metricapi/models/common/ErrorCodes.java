package com.company.dpt.metric.api.metricapi.models.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCodes {
    EXC400("INVALID INPUT"),
    EXC401("UNAUTHORIZED"),
    EXC404("NOT FOUND"),
    EXC409("ALREADY EXISTS");

    private final String value;

    ErrorCodes(final String value) {
        this.value = value;
    }
    /**
     * Get enum value.
     *
     * @return Enum value
     */
    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
