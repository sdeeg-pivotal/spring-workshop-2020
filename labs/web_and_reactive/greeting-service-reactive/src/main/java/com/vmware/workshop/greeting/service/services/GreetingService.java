package com.vmware.workshop.greeting.service.services;

import com.vmware.workshop.greeting.service.dom.Greeting;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class GreetingService {
    final private Greeting greeting;

    final private WebClient webClient;
    public GreetingService(WebClient.Builder builder, Greeting greeting) {
        super();
        this.greeting = greeting;
        this.webClient = builder.baseUrl("http://localhost:8080").build();
    }

    public Mono<Greeting> getGreeting() {
        return Mono.just(greeting);
    }

    public Mono<Greeting> webClientCall() {
        return webClient.get().uri("/greeting").retrieve().bodyToMono(Greeting.class);
    }
}
