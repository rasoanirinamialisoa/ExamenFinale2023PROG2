package com.example.examenfinale2023prog2.entity;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class DetailDeLaCommandeEntity {
    private Long idDetailDeLaCommande;
    private Integer quantiteCommande;
    private Long idProduit;
    private Long idCommande;

    public DetailDeLaCommandeEntity() {

    }
}

