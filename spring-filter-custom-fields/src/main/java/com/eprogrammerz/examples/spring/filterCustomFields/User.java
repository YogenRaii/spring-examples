package com.eprogrammerz.examples.spring.filterCustomFields;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
    private Float salary;
    private String gender;
}
