package org.example.commande_service.controller;

import org.example.commande_service.dto.CommandeDTO;
import org.example.commande_service.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/commandes")
public class CommandeController {
    @Autowired
    private CommandeService service;

    @GetMapping("/lister")
    public List<CommandeDTO> getAllCommandes() {
        return service.getAllCommandes();
    }

    @GetMapping("/{id}")
    public CommandeDTO getCommandeById(@PathVariable Long id) {
        return service.getCommandeById(id);
    }

    @PostMapping("/add")
    public CommandeDTO createCommande(@RequestBody CommandeDTO commandeDTO) {
        return service.saveCommande(commandeDTO);
    }

    @PutMapping("/{id}")
    public CommandeDTO updateCommande(@PathVariable Long id, @RequestBody CommandeDTO commandeDTO) {
        return service.updateCommande(id, commandeDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable Long id) {
        service.deleteCommande(id);
    }

    @GetMapping("/recent")
    public List<CommandeDTO> getRecentCommandes(@RequestParam(defaultValue = "10") int days) {
        return service.getRecentCommandes(days);
    }
    @GetMapping("/recentT")
    public List<CommandeDTO> getRecentCommandes2(@RequestParam(defaultValue = "20") int days) {
        return service.getRecentCommandes(days);
    }
}