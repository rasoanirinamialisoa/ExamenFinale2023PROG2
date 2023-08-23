package com.example.examenfinale2023prog2.repository;

import com.example.examenfinale2023prog2.entity.CommandeEntity;

import java.sql.SQLException;
import java.util.List;

public interface CommandeRepository {
    List<CommandeEntity> getAllCommandes() throws SQLException;
    CommandeEntity getCommandeById(Long id) throws SQLException;
    CommandeEntity createCommande(CommandeEntity commande) throws SQLException;
    CommandeEntity updateCommande(Long id, CommandeEntity commande) throws SQLException;
    void deleteCommande(Long id) throws SQLException;
}

