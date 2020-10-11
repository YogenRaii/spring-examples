package com.eprogrammez.examples.webflux.controllers;

import com.eprogrammez.examples.webflux.models.Ingredient;
import com.eprogrammez.examples.webflux.models.Taco;
import com.eprogrammez.examples.webflux.repositories.TacoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TacoControllerTest {

    private TacoRepository tacoRepository;

    @BeforeEach
    public void setup() {
        tacoRepository = Mockito.mock(TacoRepository.class);
    }

    @Test
    void tacoById() {
        String tacoId = UUID.randomUUID().toString();
        Taco taco = createTaco(tacoId);
        when(tacoRepository.findById(tacoId)).thenReturn(Mono.just(taco));

        WebTestClient client = WebTestClient.bindToController(new TacoController(tacoRepository)).build();

        client.get().uri("/tacos/{id}", tacoId).accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Taco.class)
                .isEqualTo(taco);
    }

    @Test
    void createTaco() {
        String tacoId = UUID.randomUUID().toString();
        Taco savedTaco = createTaco(tacoId);
        when(tacoRepository.saveAll(any(Mono.class))).thenReturn(Flux.just(savedTaco));

        WebTestClient client = WebTestClient.bindToController(new TacoController(tacoRepository)).build();

        client.post().uri("/tacos").contentType(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Taco.class)
                .isEqualTo(savedTaco);
    }

    private Taco createTaco(String id) {
        Taco taco = new Taco();
        taco.setId(id);
        taco.setCreatedAt(LocalDateTime.now());
        taco.setName("Taco " + id);
        taco.setIngredients(
                Arrays.asList(
                        new Ingredient(UUID.randomUUID().toString(), "Ing A", Ingredient.Type.CHEESE),
                        new Ingredient(UUID.randomUUID().toString(), "Ing B", Ingredient.Type.PROTEIN)
                )
        );

        return taco;
    }
}