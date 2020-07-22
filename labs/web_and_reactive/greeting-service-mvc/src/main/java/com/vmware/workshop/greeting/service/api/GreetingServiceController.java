package com.vmware.workshop.greeting.service.api;

import com.vmware.workshop.greeting.service.dom.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetingServiceController {
    final private Greeting greeting;
    final private RestTemplate restTemplate;

    public GreetingServiceController(Greeting greeting, RestTemplate restTemplate) {
        super();
        this.greeting = greeting;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/greeting")
    Greeting getGreeting() {
        return this.greeting;
    }

    @PostMapping("/echo")
    Greeting echo(@RequestBody Greeting inGreeting) {
        return new Greeting("echo: "+inGreeting.greeting);
    }

    @GetMapping("/rest-call")
    Greeting restCall() {
        Greeting returnedGreeting = restTemplate.getForObject("/greeting", Greeting.class);
        return new Greeting("rest response: "+returnedGreeting.greeting);
    }
}
