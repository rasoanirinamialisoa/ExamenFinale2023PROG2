package com.example.examenfinale2023prog2.service;


import com.example.examenfinale2023prog2.entity.CommandeEntity;
import com.example.examenfinale2023prog2.repository.CommandeRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @SneakyThrows
    @Override
    public List<CommandeEntity> getAllCommandes() {
        return commandeRepository.getAllCommandes();
    }
    @SneakyThrows
    @Override
    public CommandeEntity getCommandeById(Long id) {
        return commandeRepository.getCommandeById(id);
    }
    @SneakyThrows
    @Override
    public CommandeEntity createCommande(CommandeEntity commande) {
        return commandeRepository.createCommande(commande);
    }
    @SneakyThrows
    @Override
    public CommandeEntity updateCommande(Long id, CommandeEntity commande) {
        return commandeRepository.updateCommande(id, commande);
    }
    @SneakyThrows
    @Override
    public void deleteCommande(Long id) {
        commandeRepository.deleteCommande(id);
    }
}
