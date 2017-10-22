package com.eprogrammerz.activiti.hiring.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Applicant {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String phoneNumber;
}
