package org.example.commande_service.service;


import org.example.commande_service.dto.CommandeDTO;

import java.util.List;

public interface CommandeService {
    List<CommandeDTO> getAllCommandes();
    CommandeDTO getCommandeById(Long id);
    CommandeDTO saveCommande(CommandeDTO commandeDTO);
    CommandeDTO updateCommande(Long id, CommandeDTO commandeDTO);
    void deleteCommande(Long id);
    List<CommandeDTO> getRecentCommandes(int days);
}
