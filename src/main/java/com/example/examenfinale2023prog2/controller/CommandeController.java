package com.example.examenfinale2023prog2.controller;


import com.example.examenfinale2023prog2.entity.CommandeEntity;
import com.example.examenfinale2023prog2.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @GetMapping
    public List<CommandeEntity> getAllCommandes() {
        return commandeService.getAllCommandes();
    }

    @GetMapping("/{id}")
    public CommandeEntity getCommandeById(@PathVariable Long id) {
        return commandeService.getCommandeById(id);
    }

    @PostMapping
    public CommandeEntity createCommande(@RequestBody CommandeEntity commande) {
        return commandeService.createCommande(commande);
    }

    @PutMapping("/{id}")
    public CommandeEntity updateCommande(@PathVariable Long id, @RequestBody CommandeEntity commande) {
        return commandeService.updateCommande(id, commande);
    }

    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable Long id) {
        commandeService.deleteCommande(id);
    }
}

