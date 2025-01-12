package org.example.commande_service.Repository;


import org.example.commande_service.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    @Query("SELECT c FROM Commande c WHERE c.date >= :fromDate")
    List<Commande> findRecentCommandes(LocalDate fromDate);
}
