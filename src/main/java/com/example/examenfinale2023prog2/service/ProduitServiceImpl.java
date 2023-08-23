package com.example.examenfinale2023prog2.service;


import com.example.examenfinale2023prog2.entity.ProduitEntity;
import com.example.examenfinale2023prog2.repository.ProduitRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    @SneakyThrows
    @Override
    public List<ProduitEntity> getAllProduits() {
        return produitRepository.getAllProduits();
    }

    @SneakyThrows
    @Override
    public ProduitEntity getProduitById(Long id) {
        return produitRepository.getProduitById(id);
    }

    @SneakyThrows
    @Override
    public ProduitEntity createProduit(ProduitEntity produit) {
        return produitRepository.createProduit(produit);
    }
    @SneakyThrows
    @Override
    public ProduitEntity updateProduit(Long id, ProduitEntity produit) {
        return produitRepository.updateProduit(id, produit);
    }
    @SneakyThrows
    @Override
    public void deleteProduit(Long id) {
        produitRepository.deleteProduit(id);
    }
}
