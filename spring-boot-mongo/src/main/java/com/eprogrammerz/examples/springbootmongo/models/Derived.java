package com.eprogrammerz.examples.springbootmongo.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Derived extends Base {
    private String fieldB;
}
