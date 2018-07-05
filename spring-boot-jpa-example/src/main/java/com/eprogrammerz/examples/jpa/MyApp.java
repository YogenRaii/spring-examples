package com.eprogrammerz.examples.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class MyApp implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }

    @Autowired
    private ApplicantRepository applicantRepository;

    @Override
    public void run(String... strings) throws Exception {
        Applicant applicant1 = new Applicant("yogen rai-1", "yogen.rai@email.com", "+1-990-980-9877");
        Applicant applicant2 = new Applicant("yogen rai-2", "yogen.rai@email.com", "+1-990-980-9877");
        Applicant applicant3 = new Applicant("yogen rai-3", "yogen.rai@email.com", "+1-990-980-9877");
        Applicant applicant4 = new Applicant("yogen rai-4", "yogen.rai@email.com", "+1-990-980-9877");
        List<Applicant> applicants = Arrays.asList(applicant1, applicant2, applicant3, applicant4);

        applicants.forEach(applicant -> {
            applicant.setName(applicant.getName() + UUID.randomUUID());
            Applicant saved = applicantRepository.save(applicant);
        });

//        List<Applicant> savedApplicants = applicantRepository.saveAll(applicants);

//        System.out.println(savedApplicants);

        System.out.println("-------------All applicants----------------");
        applicantRepository.findAll().forEach(System.out::println);

        System.out.println("-------------Deleting----------------");
        applicantRepository.deleteById("I-3");

        Applicant applicant = new Applicant("yogen raiii", "yogen.rai@email.com", "+1-990-980-9877");
        Applicant saved = applicantRepository.save(applicant);
        System.out.println("-------------All applicants----------------");
        applicantRepository.findAll().forEach(System.out::println);
    }
}
