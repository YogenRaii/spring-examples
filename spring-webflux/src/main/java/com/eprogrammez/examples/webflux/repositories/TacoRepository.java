package com.eprogrammez.examples.webflux.repositories;

import com.eprogrammez.examples.webflux.models.Taco;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TacoRepository extends ReactiveCrudRepository<Taco, Long> {
}
