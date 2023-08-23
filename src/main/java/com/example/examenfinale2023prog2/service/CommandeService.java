package com.example.examenfinale2023prog2.service;

import com.example.examenfinale2023prog2.entity.CommandeEntity;


import java.util.List;


public interface CommandeService {
    List<CommandeEntity> getAllCommandes();
    CommandeEntity getCommandeById(Long id);
    CommandeEntity createCommande(CommandeEntity commande);
    CommandeEntity updateCommande(Long id, CommandeEntity commande);
    void deleteCommande(Long id);
}
