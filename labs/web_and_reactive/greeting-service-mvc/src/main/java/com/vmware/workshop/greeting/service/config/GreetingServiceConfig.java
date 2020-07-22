package com.vmware.workshop.greeting.service.config;

import com.vmware.workshop.greeting.service.dom.Greeting;
import com.vmware.workshop.greeting.service.service.GreetingReactiveService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.util.DefaultUriBuilderFactory;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class GreetingServiceConfig {

    @Value("${app.greeting:Doh!}")
    private String greetingValue = "";

    @Bean(name="myGreeting")
    Greeting theGreeting() {
        return new Greeting(greetingValue);
    }

    @Bean
    RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        String baseUrl = "http://localhost:8080/";
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(baseUrl));
        return restTemplate;
    }

    @Bean
    RouterFunction<?> routes(GreetingReactiveService greetingReactiveService) {
        return RouterFunctions
                .route(GET("/reactive-greeting"),
                        serverRequest -> ServerResponse.ok().body(greetingReactiveService.getGreeting(), Greeting.class));
    }
}
