package com.project.tcgp.models;

import com.project.tcgp.constants.RareCarte;
import jakarta.persistence.*;

@Entity
public class Carte {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "pokemon_id")
    private Pokemon pokemon;

    @Enumerated(EnumType.STRING)
    private RareCarte rare;

    // Getters and setters
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public RareCarte getRare() {
        return rare;
    }

    public void setRare(RareCarte rare) {
        this.rare = rare;
    }
}