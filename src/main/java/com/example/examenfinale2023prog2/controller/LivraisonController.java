package com.example.examenfinale2023prog2.controller;


import com.example.examenfinale2023prog2.entity.LivraisonEntity;
import com.example.examenfinale2023prog2.service.LivraisonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livraisons")
public class LivraisonController {

    @Autowired
    private LivraisonService livraisonService;

    @GetMapping
    public List<LivraisonEntity> getAllLivraisons() {
        return livraisonService.getAllLivraisons();
    }

    @GetMapping("/{id}")
    public LivraisonEntity getLivraisonById(@PathVariable Long id) {
        return livraisonService.getLivraisonById(id);
    }

    @PostMapping
    public LivraisonEntity createLivraison(@RequestBody LivraisonEntity livraison) {
        return livraisonService.createLivraison(livraison);
    }

    @PutMapping("/{id}")
    public LivraisonEntity updateLivraison(@PathVariable Long id, @RequestBody LivraisonEntity livraison) {
        return livraisonService.updateLivraison(id, livraison);
    }

    @DeleteMapping("/{id}")
    public void deleteLivraison(@PathVariable Long id) {
        livraisonService.deleteLivraison(id);
    }
}
