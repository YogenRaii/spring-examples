package com.eprogrammez.examples.webflux.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;
import org.springframework.data.couchbase.core.mapping.id.IdAttribute;


@Data
@RequiredArgsConstructor
@Document
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationStrategy.USE_ATTRIBUTES, delimiter = "-")
    private final String id;
    @Field @IdAttribute
    private final String name;
    @Field @IdAttribute
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, CHEESE, SAUCE
    }
}
