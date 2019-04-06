package com.eprogrammerz.examples.apacheCamel.models;

import lombok.*;

/**
 * Created by Yogen on 10/8/2017.
 */
@Data
@AllArgsConstructor
public class Message {
    private Integer id;
    private String content;
}
