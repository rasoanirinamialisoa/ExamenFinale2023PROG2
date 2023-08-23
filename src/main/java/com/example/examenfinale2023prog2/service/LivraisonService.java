package com.example.examenfinale2023prog2.service;


import com.example.examenfinale2023prog2.entity.LivraisonEntity;

import java.util.List;

public interface LivraisonService {
    List<LivraisonEntity> getAllLivraisons();
    LivraisonEntity getLivraisonById(Long id);
    LivraisonEntity createLivraison(LivraisonEntity livraison);
    LivraisonEntity updateLivraison(Long id, LivraisonEntity livraison);
    void deleteLivraison(Long id);
}
