package com.eprogrammerz.examples.spring.springtrasaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@Scope("prototype")
public class SpringTxThread extends Thread {
    private static final Logger log = LoggerFactory.getLogger(SpringTxThread.class);

    @Override
    public void run() {
        log.info("Running SpringTxThread . . . {}", getName());
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + ":" + i);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
