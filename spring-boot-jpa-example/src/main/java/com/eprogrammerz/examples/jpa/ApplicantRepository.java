package com.eprogrammerz.examples.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
    @Modifying
    @Query("delete from Applicant a where a.applicantId=:id")
    void deleteById(@Param("id") String id);
}