package com.example.examenfinale2023prog2.service;
import com.example.examenfinale2023prog2.entity.FournisseurEntity;

import java.util.List;

public interface FournisseurService {
    List<FournisseurEntity> getAllFournisseurs();
    FournisseurEntity getFournisseurById(Long id);
    FournisseurEntity createFournisseur(FournisseurEntity fournisseur);
    FournisseurEntity updateFournisseur(Long id, FournisseurEntity fournisseur);
    void deleteFournisseur(Long id);
}
