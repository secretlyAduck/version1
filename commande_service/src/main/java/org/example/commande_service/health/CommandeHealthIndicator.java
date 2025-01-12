package org.example.commande_service.health;


import org.example.commande_service.Repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CommandeHealthIndicator implements HealthIndicator {

    @Autowired
    private CommandeRepository commandeRepository;

    @Override
    public Health health() {
        // Check the number of commandes in the database
        long count = commandeRepository.count();

        if (count > 0) {
            return Health.up()
                    .withDetail("message", "Commandes exist in the database")
                    .withDetail("commandesCount", count)
                    .build();
        } else {
            return Health.down()
                    .withDetail("message", "No commandes found in the database")
                    .build();
        }
    }
}
