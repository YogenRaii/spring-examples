package com.eprogrammerz.examples.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by Yogen on 2/24/2017.
 */
@RestController
public class LoginController {
    @RequestMapping("/user")
    public Principal getUser(Principal principal) {
        return principal;
    }
}
