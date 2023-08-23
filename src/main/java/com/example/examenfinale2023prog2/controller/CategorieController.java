package com.example.examenfinale2023prog2.controller;

import com.example.examenfinale2023prog2.entity.CategorieEntity;
import com.example.examenfinale2023prog2.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping
    public List<CategorieEntity> getAllCategories() {
        return categorieService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategorieEntity getCategorieById(@PathVariable Long id) {
        return categorieService.getCategorieById(id);
    }

    @PostMapping
    public CategorieEntity createCategorie(@RequestBody CategorieEntity categorie) {
        return categorieService.createCategorie(categorie);
    }

    @PutMapping("/{id}")
    public CategorieEntity updateCategorie(@PathVariable Long id, @RequestBody CategorieEntity categorie) {
        return categorieService.updateCategorie(id, categorie);
    }

    @DeleteMapping("/{id}")
    public void deleteCategorie(@PathVariable Long id) {
        categorieService.deleteCategorie(id);
    }
}

