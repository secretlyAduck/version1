package org.example.commande_service.service;


import org.example.commande_service.dto.CommandeDTO;
import org.example.commande_service.model.Commande;
import org.example.commande_service.Repository.CommandeRepository;
import org.example.commande_service.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommandeServiceImpl implements CommandeService {
    @Autowired
    private CommandeRepository repository;

    @Override
    public List<CommandeDTO> getAllCommandes() {
        return repository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CommandeDTO getCommandeById(Long id) {
        Optional<Commande> commande = repository.findById(id);
        return commande.map(this::mapToDTO)
                .orElseThrow(() -> new RuntimeException("Commande not found with id: " + id));
    }

    @Override
    public CommandeDTO saveCommande(CommandeDTO commandeDTO) {
        Commande commande = mapToEntity(commandeDTO);
        Commande savedCommande = repository.save(commande);
        return mapToDTO(savedCommande);
    }

    @Override
    public CommandeDTO updateCommande(Long id, CommandeDTO commandeDTO) {
        Optional<Commande> existingCommande = repository.findById(id);
        if (existingCommande.isPresent()) {
            Commande commande = existingCommande.get();
            commande.setDescription(commandeDTO.getDescription());
            commande.setQuantite(commandeDTO.getQuantite());
            commande.setDate(commandeDTO.getDate());
            commande.setMontant(commandeDTO.getMontant());
            Commande updatedCommande = repository.save(commande);
            return mapToDTO(updatedCommande);
        } else {
            throw new RuntimeException("Commande not found with id: " + id);
        }
    }

    @Override
    public void deleteCommande(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Commande not found with id: " + id);
        }
    }

    @Override
    public List<CommandeDTO> getRecentCommandes(int days) {
        LocalDate fromDate = LocalDate.now().minusDays(days);
        return repository.findRecentCommandes(fromDate)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Mapper: Entity to DTO
    private CommandeDTO mapToDTO(Commande commande) {
        return new CommandeDTO(
                commande.getId(),
                commande.getDescription(),
                commande.getQuantite(),
                commande.getDate(),
                commande.getMontant()
        );
    }

    // Mapper: DTO to Entity
    private Commande mapToEntity(CommandeDTO dto) {
        return new Commande(
                dto.getId(),
                dto.getDescription(),
                dto.getQuantite(),
                dto.getDate(),
                dto.getMontant()
        );
    }
}
