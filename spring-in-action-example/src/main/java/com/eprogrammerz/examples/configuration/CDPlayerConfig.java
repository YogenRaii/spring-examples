package com.eprogrammerz.examples.configuration;

import com.eprogrammerz.examples.models.CompactDisc;
import com.eprogrammerz.examples.models.impl.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 542596 on 2/12/2017.
 */
@Configuration
@ComponentScan(basePackages = "com.eprogrammerz.examples")
public class CDPlayerConfig {
    @Bean
    public CompactDisc getCompactDisc() {
        return new SgtPeppers("Hello","Adele");
    }
}
