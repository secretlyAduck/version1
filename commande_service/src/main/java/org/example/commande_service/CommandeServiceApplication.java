package org.example.commande_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  // Enables Eureka Client for Service Discovery
public class CommandeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommandeServiceApplication.class, args);
    }
}
