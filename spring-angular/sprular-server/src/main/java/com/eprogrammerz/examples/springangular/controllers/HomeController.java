package com.eprogrammerz.examples.springangular.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {
    @RequestMapping
    public String home() {
        return "index.html";
    }
}
