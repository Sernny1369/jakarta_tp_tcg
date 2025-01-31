package com.project.tcgp.dto;

import com.project.tcgp.constants.RareCarte;

public class TirageCarte {
    private String uuid;
    private String nomPokemon;
    private RareCarte rare;

    // Getters and setters
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNomPokemon() {
        return nomPokemon;
    }

    public void setNomPokemon(String nomPokemon) {
        this.nomPokemon = nomPokemon;
    }

    public RareCarte getRare() {
        return rare;
    }

    public void setRare(RareCarte rare) {
        this.rare = rare;
    }
}