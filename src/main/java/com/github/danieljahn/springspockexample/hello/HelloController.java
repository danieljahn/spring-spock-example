package com.github.danieljahn.springspockexample.hello;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.text.MessageFormat;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @PostMapping
    public Mono<HelloResponse> sayHello(@RequestBody HelloRequest body) {
        final var response = HelloResponse
                .builder()
                .message(MessageFormat.format("Hello, {0}!", body.name))
                .build();
        return Mono.just(response);
    }
}
