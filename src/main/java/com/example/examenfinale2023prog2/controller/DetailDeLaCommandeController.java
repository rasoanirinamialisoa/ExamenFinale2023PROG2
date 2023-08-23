package com.example.examenfinale2023prog2.controller;


import com.example.examenfinale2023prog2.entity.DetailDeLaCommandeEntity;
import com.example.examenfinale2023prog2.service.DetailDeLaCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details-commande")
public class DetailDeLaCommandeController {

    @Autowired
    private DetailDeLaCommandeService detailDeLaCommandeService;

    @GetMapping
    public List<DetailDeLaCommandeEntity> getAllDetailsDeLaCommande() {
        return detailDeLaCommandeService.getAllDetailsDeLaCommande();
    }

    @GetMapping("/{id}")
    public DetailDeLaCommandeEntity getDetailDeLaCommandeById(@PathVariable Long id) {
        return detailDeLaCommandeService.getDetailDeLaCommandeById(id);
    }

    @PostMapping
    public DetailDeLaCommandeEntity createDetailDeLaCommande(@RequestBody DetailDeLaCommandeEntity detail) {
        return detailDeLaCommandeService.createDetailDeLaCommande(detail);
    }

    @PutMapping("/{id}")
    public DetailDeLaCommandeEntity updateDetailDeLaCommande(@PathVariable Long id, @RequestBody DetailDeLaCommandeEntity detail) {
        return detailDeLaCommandeService.updateDetailDeLaCommande(id, detail);
    }

    @DeleteMapping("/{id}")
    public void deleteDetailDeLaCommande(@PathVariable Long id) {
        detailDeLaCommandeService.deleteDetailDeLaCommande(id);
    }
}
