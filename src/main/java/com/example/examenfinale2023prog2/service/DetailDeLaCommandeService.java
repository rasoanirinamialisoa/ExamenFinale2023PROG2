package com.example.examenfinale2023prog2.service;



import com.example.examenfinale2023prog2.entity.DetailDeLaCommandeEntity;

import java.util.List;

public interface DetailDeLaCommandeService {
    List<DetailDeLaCommandeEntity> getAllDetailsDeLaCommande();
    DetailDeLaCommandeEntity getDetailDeLaCommandeById(Long id);
    DetailDeLaCommandeEntity createDetailDeLaCommande(DetailDeLaCommandeEntity detail);
    DetailDeLaCommandeEntity updateDetailDeLaCommande(Long id, DetailDeLaCommandeEntity detail);
    void deleteDetailDeLaCommande(Long id);
}
