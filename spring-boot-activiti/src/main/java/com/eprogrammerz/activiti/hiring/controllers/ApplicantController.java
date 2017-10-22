package com.eprogrammerz.activiti.hiring.controllers;

import com.eprogrammerz.activiti.hiring.models.Applicant;
import com.eprogrammerz.activiti.hiring.repositories.ApplicantRepository;
import lombok.RequiredArgsConstructor;
import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class ApplicantController {
    private final RuntimeService runtimeService;
    private final ApplicantRepository applicantRepository;

    @PostMapping(value = "/start-hire-process", consumes= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void startHireProcess(@RequestBody Applicant applicant) {
        applicantRepository.save(applicant);

        Map<String, Object> variables = new HashMap<>();
        variables.put("applicant", applicant);
        runtimeService.startProcessInstanceByKey("hireProcessWithJpa", variables);
    }
}
