package com.example.examenfinale2023prog2.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ProduitEntity {
    private Long idProduit;
    private String nomProduit;
    private String description;
    private Double prixUnitaire;
    private Integer quantiteEnStock;
    private LocalDate dateAjout;
    private LocalDate dateMiseAJour;
    private Long idCategorie;
    private Long idFournisseur;

    public ProduitEntity() {

    }
}
