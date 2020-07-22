package com.vmware.workshop.greeting.service.service;

import com.vmware.workshop.greeting.service.dom.Greeting;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GreetingReactiveService {
    public Mono<Greeting> getGreeting() {
        return Mono.just(new Greeting("hello, reactive"));
    }
}
