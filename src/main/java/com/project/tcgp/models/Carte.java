package com.project.tcgp.models;
import com.project.tcgp.constants.TypePokemon;
import com.project.tcgp.constants.RareCarte;
import jakarta.persistence.*;

@Entity
public class Carte {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private String uuid;

    private String nom;

    private Integer niveau;

    @Enumerated(EnumType.STRING)
    private TypePokemon type;

    @Enumerated(EnumType.STRING)
    private RareCarte rare;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    public TypePokemon getType() {
        return type;
    }

    public void setType(TypePokemon type) {
        this.type = type;
    }

    public RareCarte getRare() {
        return rare;
    }

    public void setRare(RareCarte rare) {
        this.rare = rare;
    }

    public String getUuid() {
        return uuid;
    }
}
