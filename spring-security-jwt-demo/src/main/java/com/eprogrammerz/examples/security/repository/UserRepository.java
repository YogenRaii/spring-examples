package com.eprogrammerz.examples.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eprogrammerz.examples.security.models.User;

/**
 * Created by Yogen
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
