package com.eprogrammez.examples.webflux.controllers;

import com.eprogrammez.examples.webflux.models.Taco;
import com.eprogrammez.examples.webflux.repositories.TacoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/tacos")
public class TacoController {
    private final TacoRepository tacoRepository;

    @GetMapping("/recent")
    public Flux<Taco> recentTacos() {
        return tacoRepository.findAll().take(12);
    }

    @GetMapping("/{id}")
    public Mono<Taco> tacoById(@PathVariable String id) {
        return tacoRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Taco> createTaco(@RequestBody Mono<Taco> tacoMono) {
        return tacoRepository.saveAll(tacoMono).next();
    }

}
