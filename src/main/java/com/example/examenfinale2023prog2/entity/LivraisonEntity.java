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
public class LivraisonEntity {
    private Long idLivraison;
    private LocalDate dateLivraison;
    private Boolean statutLivraison;
    private Long idCommande;

    public LivraisonEntity() {

    }

    public boolean isStatutLivraison() {
        return statutLivraison;
    }
}

