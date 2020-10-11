package com.eprogrammez.examples.webflux.repositories;

import com.eprogrammez.examples.webflux.models.Order;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;

public interface OrderRepository extends ReactiveCouchbaseRepository<Order, String> {
}
