package com.eprogrammerz.examples.config;

import com.eprogrammerz.examples.exception.ResourceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by 542596 on 3/16/2017.
 */
@Component
public class PropertiesConfigurer {
    @Value("${properties.path}")
    private String propertiesFilePath;

    @Autowired
    private DynamicEnvironmentProperties dynamicEnvironmentProperties;

    public PropertiesConfigurer() {

    }

    @PostConstruct
    public void loadProperties() {
        try {
            dynamicEnvironmentProperties.loadProperties(propertiesFilePath);
        } catch (ResourceException e) {
            e.printStackTrace();
        }
    }
}
