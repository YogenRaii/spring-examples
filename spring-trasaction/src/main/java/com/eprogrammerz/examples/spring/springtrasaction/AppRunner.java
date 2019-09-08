package com.eprogrammerz.examples.spring.springtrasaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

@Component
public class AppRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(AppRunner.class);

    @Autowired
    private BookingService bookingService;

    @Override
    public void run(String... args) throws Exception {
        bookingService.book("yogen", "pratima", "esma");

        List<String> bookings = bookingService.findAllBookings().get();
        Assert.isTrue(bookings.size() == 3, "Booking should be for 3");

        log.info("Bookings: {}", bookings);

        try {
            bookingService.book("sabina", "prateema", "yogs");
        } catch (RuntimeException e) {
            log.info(" --- this is because 'prateema' violates constraints ----");
            log.error(e.getMessage());
        }

        bookings = bookingService.findAllBookings().get();
        Assert.isTrue(bookings.size() == 3, "Still booking should be for 3");

        log.info("Bookings: {}", bookings);

        try {
            bookingService.book("sabina", null, "yogs");
        } catch (RuntimeException e) {
            log.info(" --- this is because 'null' violates constraints ----");
            log.error(e.getMessage());
        }
        bookings = bookingService.findAllBookings().get();
        Assert.isTrue(bookings.size() == 3, "Still booking should be for 3");

        log.info("Bookings: {}", bookings);


    }
}
