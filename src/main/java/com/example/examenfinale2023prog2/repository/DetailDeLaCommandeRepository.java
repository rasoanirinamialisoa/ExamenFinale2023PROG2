package com.example.examenfinale2023prog2.repository;


import com.example.examenfinale2023prog2.entity.DetailDeLaCommandeEntity;

import java.sql.SQLException;
import java.util.List;

public interface DetailDeLaCommandeRepository {
    List<DetailDeLaCommandeEntity> getAllDetailsDeLaCommande() throws SQLException;
    DetailDeLaCommandeEntity getDetailDeLaCommandeById(Long id) throws SQLException;
    DetailDeLaCommandeEntity createDetailDeLaCommande(DetailDeLaCommandeEntity detail) throws SQLException;
    DetailDeLaCommandeEntity updateDetailDeLaCommande(Long id, DetailDeLaCommandeEntity detail) throws SQLException;
    void deleteDetailDeLaCommande(Long id) throws SQLException;
}

