package com.demo.javaopentelemetry.controller;

import com.demo.javaopentelemetry.model.Dice;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Scope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * @author cash.wu
 * @since 2024/10/01
 */
@RestController
public class RollController {

    private static final Logger log = LoggerFactory.getLogger(RollController.class);

    private final ObservationRegistry observationRegistry;

    public RollController(ObservationRegistry observationRegistry) {
        this.observationRegistry = observationRegistry;
    }

    @GetMapping("/rolldice")
    public List<Integer> index(@RequestParam("player") Optional<String> player,
                               @RequestParam("rolls") Optional<Integer> rolls) {

        return Observation.createNotStarted("rolldice", observationRegistry).observe(() -> {
            if (rolls.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "missing rolls parameter");
            }

            List<Integer> result = new Dice(1, 6).rollTheDice(rolls.get());

            if (player.isPresent()) {
                log.info("{} is rolling the dice: {}", player.get(), result);
            } else {
                log.info("anonymous player is rolling the dice : {}", result);
            }

            return result;
        });
    }
}
