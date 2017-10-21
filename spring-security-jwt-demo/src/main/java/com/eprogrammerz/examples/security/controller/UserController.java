package com.eprogrammerz.examples.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eprogrammerz.examples.security.models.User;
import com.eprogrammerz.examples.security.repository.UserRepository;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Value("${jwt.header}")
    private String tokenHeader;

    
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
    	List<User> users = this.userRepository.findAll();
    	return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
