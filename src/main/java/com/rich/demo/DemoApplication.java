package com.rich.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication // Marks this as a Spring Boot application
@RestController        // Tells Spring this class handles web requests
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/") // Maps HTTP GET requests for the root URL to this method
    public String helloWorld() {
        return "Hello World, Spring Boot!";
    }
}