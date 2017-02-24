package com.eprogrammerz.examples.models.impl;

import com.eprogrammerz.examples.models.CompactDisc;
import com.eprogrammerz.examples.models.MediaPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 542596 on 2/12/2017.
 */
@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    public void play() {
        cd.play();
    }
}
