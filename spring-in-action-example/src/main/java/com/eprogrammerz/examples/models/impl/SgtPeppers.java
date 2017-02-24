package com.eprogrammerz.examples.models.impl;

import com.eprogrammerz.examples.models.CompactDisc;

/**
 * Created by 542596 on 2/12/2017.
 */
//@Component
public class SgtPeppers implements CompactDisc {
    private String title;// = "Hello";
    private String artist;// = "Adele";

    public SgtPeppers(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public void play() {
        System.out.print(String.format("Playing %s by %s.", title, artist));
    }
}
