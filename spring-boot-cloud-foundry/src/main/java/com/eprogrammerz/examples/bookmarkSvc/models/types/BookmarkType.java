package com.eprogrammerz.examples.bookmarkSvc.models.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BookmarkType {
    GENERAL("general"),
    COMPLEX("complex");

    private final String value;

    /**
     * Internal constructor.
     *
     * @param value Enum value
     */
    BookmarkType(final String value) {
        this.value = value;
    }

    @JsonCreator
    public static BookmarkType forValue(final String value) {
        for (BookmarkType bookmarkType : values()) {
            if (bookmarkType.value.equalsIgnoreCase(value)) {
                return bookmarkType;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + value + "]");
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
