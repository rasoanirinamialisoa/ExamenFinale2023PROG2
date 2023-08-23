package com.example.examenfinale2023prog2.service;


import com.example.examenfinale2023prog2.entity.LivraisonEntity;
import com.example.examenfinale2023prog2.repository.LivraisonRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivraisonServiceImpl implements LivraisonService {

    @Autowired
    private LivraisonRepository livraisonRepository;

    @SneakyThrows
    @Override
    public List<LivraisonEntity> getAllLivraisons() {
        return livraisonRepository.getAllLivraisons();
    }
    @SneakyThrows
    @Override
    public LivraisonEntity getLivraisonById(Long id) {
        return livraisonRepository.getLivraisonById(id);
    }
    @SneakyThrows
    @Override
    public LivraisonEntity createLivraison(LivraisonEntity livraison) {
        return livraisonRepository.createLivraison(livraison);
    }
    @SneakyThrows
    @Override
    public LivraisonEntity updateLivraison(Long id, LivraisonEntity livraison) {
        return livraisonRepository.updateLivraison(id, livraison);
    }
    @SneakyThrows
    @Override
    public void deleteLivraison(Long id) {
        livraisonRepository.deleteLivraison(id);
    }
}
