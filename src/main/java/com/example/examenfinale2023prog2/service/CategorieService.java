package com.example.examenfinale2023prog2.service;
import com.example.examenfinale2023prog2.entity.CategorieEntity;

import java.util.List;

public interface CategorieService {
    List<CategorieEntity> getAllCategories();
    CategorieEntity getCategorieById(Long id);
    CategorieEntity createCategorie(CategorieEntity categorie);
    CategorieEntity updateCategorie(Long id, CategorieEntity categorie);
    void deleteCategorie(Long id);
}

