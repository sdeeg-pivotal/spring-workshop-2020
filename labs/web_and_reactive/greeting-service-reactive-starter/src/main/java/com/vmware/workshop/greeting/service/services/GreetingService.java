package com.vmware.workshop.greeting.service.services;

import com.vmware.workshop.greeting.service.dom.Greeting;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GreetingService {
    final private Greeting greeting;

    public GreetingService(Greeting greeting) {
        super();
        this.greeting = greeting;
    }
}
