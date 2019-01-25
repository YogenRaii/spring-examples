package com.eprogrammerz.examples.springangular.controllers;

import com.eprogrammerz.examples.springangular.models.Hero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HeroController {
    @GetMapping("/heroes")
    public List<Hero> getHeroes() {
        List<Hero> heroes = new ArrayList<>();
        heroes.add(new Hero("Yogen", "3.5"));
        heroes.add(new Hero("Ramesh", "4.5"));
        heroes.add(new Hero("Prateema", "3.7"));

        return heroes;
    }
}
