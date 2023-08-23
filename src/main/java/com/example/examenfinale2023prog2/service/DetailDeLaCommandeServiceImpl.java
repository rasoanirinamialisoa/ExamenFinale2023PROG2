package com.example.examenfinale2023prog2.service;



import com.example.examenfinale2023prog2.entity.DetailDeLaCommandeEntity;
import com.example.examenfinale2023prog2.repository.DetailDeLaCommandeRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailDeLaCommandeServiceImpl implements DetailDeLaCommandeService {

    @Autowired
    private DetailDeLaCommandeRepository detailDeLaCommandeRepository;
    @SneakyThrows
    @Override
    public List<DetailDeLaCommandeEntity> getAllDetailsDeLaCommande() {
        return detailDeLaCommandeRepository.getAllDetailsDeLaCommande();
    }
    @SneakyThrows
    @Override
    public DetailDeLaCommandeEntity getDetailDeLaCommandeById(Long id) {
        return detailDeLaCommandeRepository.getDetailDeLaCommandeById(id);
    }
    @SneakyThrows
    @Override
    public DetailDeLaCommandeEntity createDetailDeLaCommande(DetailDeLaCommandeEntity detail) {
        return detailDeLaCommandeRepository.createDetailDeLaCommande(detail);
    }
    @SneakyThrows
    @Override
    public DetailDeLaCommandeEntity updateDetailDeLaCommande(Long id, DetailDeLaCommandeEntity detail) {
        return detailDeLaCommandeRepository.updateDetailDeLaCommande(id, detail);
    }
    @SneakyThrows
    @Override
    public void deleteDetailDeLaCommande(Long id) {
        detailDeLaCommandeRepository.deleteDetailDeLaCommande(id);
    }
}

