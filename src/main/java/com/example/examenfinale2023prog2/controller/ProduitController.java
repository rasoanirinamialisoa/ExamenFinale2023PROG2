package com.example.examenfinale2023prog2.controller;

import com.example.examenfinale2023prog2.entity.ProduitEntity;
import com.example.examenfinale2023prog2.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @GetMapping
    public List<ProduitEntity> getAllProduits() {
        return produitService.getAllProduits();
    }

    @GetMapping("/{id}")
    public ProduitEntity getProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id);
    }


    @PostMapping
    public ProduitEntity createProduit(@RequestBody ProduitEntity produit) {
        return produitService.createProduit(produit);
    }

    @PutMapping("/{id}")
    public ProduitEntity updateProduit(@PathVariable Long id, @RequestBody ProduitEntity produit) {
        return produitService.updateProduit(id, produit);
    }

    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
    }
}
