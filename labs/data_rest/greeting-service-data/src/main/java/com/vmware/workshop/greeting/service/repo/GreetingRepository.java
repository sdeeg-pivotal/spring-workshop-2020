package com.vmware.workshop.greeting.service.repo;

import com.vmware.workshop.greeting.service.dom.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GreetingRepository extends JpaRepository<Greeting, Integer> {
    List<Greeting> findByText(@Param("text") String text);
}