package com.example.examenfinale2023prog2.repository;

import com.example.examenfinale2023prog2.entity.CategorieEntity;

import java.sql.SQLException;
import java.util.List;

public interface CategorieRepository {
    List<CategorieEntity> getAllCategories() throws SQLException;
    CategorieEntity getCategorieById(Long id) throws SQLException;
    CategorieEntity createCategorie(CategorieEntity categorie) throws SQLException;
    CategorieEntity updateCategorie(Long id, CategorieEntity categorie) throws SQLException;
    void deleteCategorie(Long id) throws SQLException;
}
