package com.vmware.workshop.greeting.service.api;

import com.vmware.workshop.greeting.service.dom.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingServiceController {
    final private Greeting greeting;

    public GreetingServiceController(Greeting greeting) {
        super();
        this.greeting = greeting;
    }

    @GetMapping("/greeting")
    Greeting getGreeting() {
        return this.greeting;
    }
}
