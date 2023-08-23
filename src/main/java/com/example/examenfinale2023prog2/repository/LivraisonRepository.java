package com.example.examenfinale2023prog2.repository;

import com.example.examenfinale2023prog2.entity.LivraisonEntity;

import java.sql.SQLException;
import java.util.List;

public interface LivraisonRepository {
    List<LivraisonEntity> getAllLivraisons() throws SQLException;
    LivraisonEntity getLivraisonById(Long id) throws SQLException;
    LivraisonEntity createLivraison(LivraisonEntity livraison) throws SQLException;
    LivraisonEntity updateLivraison(Long id, LivraisonEntity livraison) throws SQLException;
    void deleteLivraison(Long id) throws SQLException;
}

