package com.vmware.workshop.greeting.service.config;

import com.vmware.workshop.greeting.service.dom.Greeting;
import com.vmware.workshop.greeting.service.services.GreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class GreetingServiceConfig {

    @Value("${app.greeting:Doh!}")
    private String greetingValue = "";

    @Bean(name="myGreeting")
    Greeting theGreeting() {
        return new Greeting(greetingValue);
    }
}
