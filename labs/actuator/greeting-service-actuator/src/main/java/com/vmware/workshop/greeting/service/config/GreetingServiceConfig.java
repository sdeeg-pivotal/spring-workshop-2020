package com.vmware.workshop.greeting.service.config;

import com.vmware.workshop.greeting.service.dom.Greeting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GreetingServiceConfig {

    @Value("${app.greeting:Doh!}")
    private String greetingValue = "";

    @Bean(name="myGreeting")
    Greeting theGreeting() {
        return new Greeting(greetingValue);
    }
}
