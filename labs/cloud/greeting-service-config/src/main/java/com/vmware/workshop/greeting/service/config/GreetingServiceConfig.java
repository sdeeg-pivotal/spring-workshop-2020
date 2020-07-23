package com.vmware.workshop.greeting.service.config;

import com.vmware.workshop.greeting.service.dom.Greeting;
import com.vmware.workshop.greeting.service.repo.GreetingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
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

    Logger logger = LoggerFactory.getLogger(GreetingServiceConfig.class);

    // Loads the database on startup
    @Bean
    ApplicationRunner loadDatabase(GreetingRepository gr) {
        return applicationRunner -> {
            logger.info("loading database..");
            gr.save(new Greeting("Hello"));
            gr.save(new Greeting("Hola"));
            gr.save(new Greeting("Ohai"));
            gr.save(new Greeting("Hello"));
            logger.info("record count: {}", gr.count());
            gr.findAll().forEach(x -> logger.debug(x.toString()));
        };
    }

//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
//        http.authorizeExchange().anyExchange().permitAll();
//        return http.build();
//    }
}
