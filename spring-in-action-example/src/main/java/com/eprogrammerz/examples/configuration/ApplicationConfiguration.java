package com.eprogrammerz.examples.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by 542596 on 2/12/2017.
 */
@Slf4j
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.eprogrammerz.examples")
public class ApplicationConfiguration {
    @Bean(name = "viewResolver")
    public ViewResolver viewResolver() {
        log.info("viewResolver(): View Resolver Bean created.");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
    /*public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver jspViewResolver = new InternalResourceViewResolver();
        jspViewResolver.setViewClass(JstlView.class);
        jspViewResolver.setPrefix("/WEB-INF/pages/");
        jspViewResolver.setSuffix(".jsp");
        return jspViewResolver;
    }*/
}
