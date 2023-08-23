package com.example.examenfinale2023prog2.repository;

import com.example.examenfinale2023prog2.entity.FournisseurEntity;

import java.sql.SQLException;
import java.util.List;

public interface FournisseurRepository {
    List<FournisseurEntity> getAllFournisseurs() throws SQLException;
    FournisseurEntity getFournisseurById(Long id) throws SQLException;
    FournisseurEntity createFournisseur(FournisseurEntity fournisseur) throws SQLException;
    FournisseurEntity updateFournisseur(Long id, FournisseurEntity fournisseur) throws SQLException;
    void deleteFournisseur(Long id) throws SQLException;
}

