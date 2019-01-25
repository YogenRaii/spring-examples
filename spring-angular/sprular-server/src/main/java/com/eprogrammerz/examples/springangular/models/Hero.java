package com.eprogrammerz.examples.springangular.models;

public class Hero {
    private String name;
    private String rating;

    public Hero(String name, String rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }
}
