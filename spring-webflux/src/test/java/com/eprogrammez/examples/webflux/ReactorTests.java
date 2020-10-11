package com.eprogrammez.examples.webflux;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

import java.time.Duration;

/**
 * Unit tests to verify the operations on reactive streams.
 */
public class ReactorTests {
    @Test
    public void testSkipAFew() {
        Flux<String> skipFlux = Flux.just("one", "two", "skip a few", "fifty", "fifty one")
                .skip(3);

        StepVerifier.create(skipFlux)
                .expectNext("fifty")
                .expectNext("fifty one")
                .verifyComplete();
    }

    @Test
    public void testSkipAFewSeconds() {
        Flux<String> skipFlux = Flux.just("one", "two", "skip a few", "fifty", "fifty one")
                .delayElements(Duration.ofSeconds(1))
                .skip(Duration.ofSeconds(4));

        StepVerifier.create(skipFlux)
                .expectNext("fifty")
                .expectNext("fifty one")
                .verifyComplete();
    }

    @Test
    public void testMap() {
        Flux<Player> playerFlux = Flux.just("Michael Jordan", "Tom Brady", "David Warner")
                .map(player -> {
                    String[] name = player.split(" ");
                    return new Player(name[0], name[1]);
                });

        StepVerifier.create(playerFlux)
                .expectNext(new Player("Michael", "Jordan"))
                .expectNext(new Player("Tom", "Brady"))
                .expectNext(new Player("David", "Warner"))
                .verifyComplete();
    }

    @Test
    public void testFlatMap() {
        Flux<Player> playerFlux = Flux.just("Michael Jordan", "Tom Brady", "David Warner")
                .flatMap(players ->
                        Mono.just(players)
                                .map(p -> {
                                    String[] name = p.split(" ");
                                    return new Player(name[0], name[1]);
                                })
                                // subscribeOn() indicates each subscription should take place in parallel
                                // in threads equal to the number of CPU cores
                                .subscribeOn(Schedulers.parallel())
                );

        StepVerifier.create(playerFlux)
                .expectNext(new Player("Michael", "Jordan"))
                .expectNext(new Player("Tom", "Brady"))
                .expectNext(new Player("David", "Warner"))
                .verifyComplete();
    }

    @AllArgsConstructor
    @Data
    static class Player {
        private String firstName;
        private String lastName;
    }
}
