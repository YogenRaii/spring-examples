package com.eprogrammerz.examples.jpa;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PrePersist;

public class ApplicantListener {
    @Autowired
    private ApplicantRepository applicantRepository;

    @PrePersist
    public void setApplicantId(Applicant applicant) {

    }
}
