package com.example.examenfinale2023prog2.service;


import com.example.examenfinale2023prog2.entity.FournisseurEntity;
import com.example.examenfinale2023prog2.repository.FournisseurRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FournisseurServiceImpl implements FournisseurService {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @SneakyThrows
    @Override
    public List<FournisseurEntity> getAllFournisseurs() {
        return fournisseurRepository.getAllFournisseurs();
    }

    @SneakyThrows
    @Override
    public FournisseurEntity getFournisseurById(Long id) {
        return fournisseurRepository.getFournisseurById(id);
    }
    @SneakyThrows
    @Override
    public FournisseurEntity createFournisseur(FournisseurEntity fournisseur) {
        return fournisseurRepository.createFournisseur(fournisseur);
    }
    @SneakyThrows
    @Override
    public FournisseurEntity updateFournisseur(Long id, FournisseurEntity fournisseur) {
        return fournisseurRepository.updateFournisseur(id, fournisseur);
    }
    @SneakyThrows
    @Override
    public void deleteFournisseur(Long id) {
        fournisseurRepository.deleteFournisseur(id);
    }
}

