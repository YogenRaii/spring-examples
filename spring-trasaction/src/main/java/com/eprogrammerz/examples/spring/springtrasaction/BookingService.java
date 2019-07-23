package com.eprogrammerz.examples.spring.springtrasaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class BookingService {
    private final static Logger log = LoggerFactory.getLogger(BookingService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Send and forget async method
     *
     * @param persons
     */
    @Transactional
//    @Async
    public void book(String... persons) {
        for (String person : persons) {
            log.info("Booking {} in a seat . . .", person);
            jdbcTemplate.update("insert into BOOKINGS(FIRST_NAME) values(?)", person);
        }
    }

    /**
     * The result should be wrapped in CompleteableFuture for function returning value
     *
     * @return
     */
    @Async
    public CompletableFuture<List<String>> findAllBookings() {
        log.info("Querying bookings . . .");
        List<String> bookings = jdbcTemplate.query("select FIRST_NAME from BOOKINGS", ((rs, rowNum) -> rs.getString("FIRST_NAME")));
        return CompletableFuture.completedFuture(bookings);
    }
}
