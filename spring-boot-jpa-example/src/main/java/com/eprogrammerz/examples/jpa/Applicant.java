package com.eprogrammerz.examples.jpa;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "Applicant")
@Table(name = "APPLICANT")
public class Applicant {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_app_id")
    /*@GenericGenerator(
            name = "seq_app_id",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "hilo_seqeunce"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "3"),
                    @org.hibernate.annotations.Parameter(name = "optimizer", value = "hilo")
            })*/
    /*@GenericGenerator(name = "seq_app_id",
            strategy = "com.eprogrammerz.examples.jpa.ApplicantIdGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "sequence_name", value = "hibernate_sequence"),
                    @org.hibernate.annotations.Parameter(
                            name = "sequence_prefix", value = "CTC_")
            }
    )*/
//    @SequenceGenerator(name = "seq_app_id", allocationSize = 1)
//    private Integer id;
    @GeneratedValue(generator = "sequence_app_id")
    @GenericGenerator(name = "sequence_app_id", strategy = "com.eprogrammerz.examples.jpa.ApplicantIdGenerator")
    private Integer id;

    private String applicantId;

    private String name;

    private String email;

    private String phoneNumber;

    public Applicant() {

    }

    public Applicant(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(String applicantId) {
        this.applicantId = applicantId;
    }

    @PrePersist
    public void printId() {
        System.out.println("=================== " + getApplicantId());
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "id=" + id +
                ", applicantId=" + applicantId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}