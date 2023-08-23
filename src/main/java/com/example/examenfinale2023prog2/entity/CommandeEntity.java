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
public class CommandeEntity {
    private Long idCommande;
    private LocalDate dateDeCommande;
    private Boolean statusDeLaCommande;
    private Double montantDeLaCommande;

    public CommandeEntity() {

    }
}

