package com.eprogrammerz.examples.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eprogrammerz.examples.security.models.Role;


/**
 * Created by Yogen
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
