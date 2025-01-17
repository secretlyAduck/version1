package org.example.commande_service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeDTO {
    private Long id;
    private String description;
    private int quantite;
    private LocalDate date;
    private double montant;
}
