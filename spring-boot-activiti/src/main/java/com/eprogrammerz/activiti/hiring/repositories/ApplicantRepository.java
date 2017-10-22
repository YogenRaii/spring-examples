package com.eprogrammerz.activiti.hiring.repositories;

import com.eprogrammerz.activiti.hiring.models.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}
