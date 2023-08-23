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
public class FournisseurEntity {
    private Long idFournisseur;
    private String nomFournisseur;
    private String adreseFournisseur;
    private String telephone;
    private String email;

    public FournisseurEntity() {

    }
}

