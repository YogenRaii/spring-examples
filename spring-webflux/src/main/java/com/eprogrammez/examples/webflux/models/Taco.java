package com.eprogrammez.examples.webflux.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;
import org.springframework.data.couchbase.core.mapping.id.IdAttribute;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationStrategy.USE_ATTRIBUTES)
    private String id;
    @Field @IdAttribute
    private String name;
    @Field @IdAttribute
    private LocalDateTime createdAt = LocalDateTime.now();

    @Field
    private List<Ingredient> ingredients;
}
