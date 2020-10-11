package com.eprogrammez.examples.webflux.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class CouchbaseConfig {
    private String bootstrapperHost;
    private String bucketName;
    private String username;
    private String password;

    public CouchbaseConfig(@Value("${spring.couchbase.bootstrap-host}") String bootstrapperHost,
                           @Value("${spring.couchbase.bucket-name}") String bucketName,
                           @Value("${spring.couchbase.username}") String username,
                           @Value("${spring.couchbase.password}") String password) {
        this.bootstrapperHost = bootstrapperHost;
        this.bucketName = bucketName;
        this.username = username;
        this.password = password;
    }
}
