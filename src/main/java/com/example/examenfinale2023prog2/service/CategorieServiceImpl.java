package com.example.examenfinale2023prog2.service;


import com.example.examenfinale2023prog2.entity.CategorieEntity;
import com.example.examenfinale2023prog2.repository.CategorieRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;
    @SneakyThrows
    @Override
    public List<CategorieEntity> getAllCategories() {
        return categorieRepository.getAllCategories();
    }
    @SneakyThrows
    @Override
    public CategorieEntity getCategorieById(Long id) {
        return categorieRepository.getCategorieById(id);
    }
    @SneakyThrows
    @Override
    public CategorieEntity createCategorie(CategorieEntity categorie) {
        return categorieRepository.createCategorie(categorie);
    }
    @SneakyThrows
    @Override
    public CategorieEntity updateCategorie(Long id, CategorieEntity categorie) {
        return categorieRepository.updateCategorie(id, categorie);
    }
    @SneakyThrows
    @Override
    public void deleteCategorie(Long id) {
        categorieRepository.deleteCategorie(id);
    }
}
