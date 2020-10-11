package com.eprogrammez.examples.webflux.repositories;

import com.eprogrammez.examples.webflux.models.Ingredient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IngredientRepository extends ReactiveCrudRepository<Ingredient, String> {
}
