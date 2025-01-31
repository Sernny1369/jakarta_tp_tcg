package com.project.tcgp.dto;

import com.project.tcgp.constants.RareCarte;
import com.project.tcgp.models.Pokemon;


public class CreateCarte {

	private RareCarte rare;

	private String pokemonId;

    public RareCarte getRare() {
        return rare;
    }

    public void setRare(RareCarte rare) {
        this.rare = rare;
    }

    public String getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(String pokemonId) {
        this.pokemonId = pokemonId;
    }
}
