package com.eprogrammerz.examples.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MyApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }

    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public void run(String... strings) throws Exception {
        Applicant applicant1 = new Applicant("yogen rai", "yogen.rai@email.com", "+1-990-980-9877");
        Applicant applicant2 = new Applicant("yogen rai", "yogen.rai@email.com", "+1-990-980-9877");
        Applicant applicant3 = new Applicant("yogen rai", "yogen.rai@email.com", "+1-990-980-9877");
        Applicant applicant4 = new Applicant("yogen rai", "yogen.rai@email.com", "+1-990-980-9877");
        List<Applicant> applicants = Arrays.asList(applicant1, applicant2, applicant3, applicant4);

        applicants.forEach(applicant -> {
            Applicant saved = applicantRepository.save(applicant);
            System.out.println(saved);
        });

//        List<Applicant> savedApplicants = applicantRepository.saveAll(applicants);

//        System.out.println(savedApplicants);

        System.out.println("-----------------------------");
        applicantRepository.findAll().forEach(System.out::println);
    }
}
