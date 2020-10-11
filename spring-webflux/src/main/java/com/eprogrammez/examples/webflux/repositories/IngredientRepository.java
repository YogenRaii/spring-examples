package com.eprogrammez.examples.webflux.repositories;

import com.eprogrammez.examples.webflux.models.Ingredient;
import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository;

public interface IngredientRepository extends ReactiveCouchbaseRepository<Ingredient, String> {
}
