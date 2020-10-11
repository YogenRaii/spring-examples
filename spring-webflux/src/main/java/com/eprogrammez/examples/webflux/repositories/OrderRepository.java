package com.eprogrammez.examples.webflux.repositories;

import com.eprogrammez.examples.webflux.models.Order;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface OrderRepository extends ReactiveCrudRepository<Order, Long> {
}
