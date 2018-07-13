package com.eprogrammerz.examples.controllers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 542596 on 3/9/2017.
 */
@RestController
public class HomeController {
//    @Value("${comparisonChart.file.name}")
//    private String comparisonChartFileName = System.getProperty("comparisonChart.file.name");

    @RequestMapping("/")
    public String home() {
        String property = System.getProperty("key1");
        String comparisonChartFileName = System.getProperty("comparisonChart.file.name");
        String comparisonChartFile = System.getProperty("comparisonChart.file");
        return "HOME Page --> key1 = " + property + ", comparison chart file name: " + comparisonChartFileName + ", comparison chart file: " + comparisonChartFile;
    }

    @Scheduled(fixedRateString = "${refresh.rate}")
    public void fixedTask() {
        System.out.println("Time changed...");
    }
}
