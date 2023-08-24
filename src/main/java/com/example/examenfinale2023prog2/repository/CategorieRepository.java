package com.example.examenfinale2023prog2.repository;

import com.example.examenfinale2023prog2.entity.CategorieEntity;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CategorieRepository {
    List<CategorieEntity> getAllCategories() throws SQLException;
    CategorieEntity getCategorieById(Long id) throws SQLException;
    CategorieEntity createCategorie(CategorieEntity categorie) throws SQLException;
    CategorieEntity updateCategorie(Long id, CategorieEntity categorie) throws SQLException;
    ResponseEntity<Map<String, String>> deleteCategorie(Long id) throws SQLException;
}
