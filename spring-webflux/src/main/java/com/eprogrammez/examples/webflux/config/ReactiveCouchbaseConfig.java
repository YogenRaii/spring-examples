package com.eprogrammez.examples.webflux.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableReactiveCouchbaseRepositories;

@Configuration
@EnableReactiveCouchbaseRepositories(basePackages = "com.eprogrammez.examples.webflux.repositories")
public class ReactiveCouchbaseConfig extends AbstractCouchbaseConfiguration {
    private final CouchbaseConfig couchbaseConfig;

    public ReactiveCouchbaseConfig(CouchbaseConfig couchbaseConfig) {
        this.couchbaseConfig = couchbaseConfig;
    }

    @Override
    public String getConnectionString() {
        return couchbaseConfig.getBootstrapperHost();
    }

    @Override
    public String getUserName() {
        return couchbaseConfig.getUsername();
    }

    @Override
    public String getPassword() {
        return couchbaseConfig.getPassword();
    }

    @Override
    public String getBucketName() {
        return couchbaseConfig.getBucketName();
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
}
