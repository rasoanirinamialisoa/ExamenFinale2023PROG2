package com.example.examenfinale2023prog2.repository;

import com.example.examenfinale2023prog2.entity.ProduitEntity;

import java.sql.SQLException;
import java.util.List;

public interface ProduitRepository {
    List<ProduitEntity> getAllProduits() throws SQLException;
    ProduitEntity getProduitById(Long id) throws SQLException;
    ProduitEntity createProduit(ProduitEntity produit) throws SQLException;
    ProduitEntity updateProduit(Long id, ProduitEntity produit) throws SQLException;
    void deleteProduit(Long id) throws SQLException;
}

