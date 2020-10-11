package com.eprogrammez.examples.webflux.repositories;

import com.eprogrammez.examples.webflux.models.Taco;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;

public interface TacoRepository extends ReactiveCouchbaseRepository<Taco, String> {
}
