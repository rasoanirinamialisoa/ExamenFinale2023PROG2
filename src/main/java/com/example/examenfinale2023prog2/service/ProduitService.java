package com.example.examenfinale2023prog2.service;

import com.example.examenfinale2023prog2.entity.ProduitEntity;

import java.util.List;

public interface ProduitService {
    List<ProduitEntity> getAllProduits();
    ProduitEntity getProduitById(Long id);
    ProduitEntity createProduit(ProduitEntity produit);
    ProduitEntity updateProduit(Long id, ProduitEntity produit);
    void deleteProduit(Long id);
}
