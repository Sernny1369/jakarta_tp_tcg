package com.project.tcgp.dto;

import com.project.tcgp.constants.RareCarte;
import com.project.tcgp.models.Pokemon;


public class CreateCarte {

	private RareCarte rare;

	private Pokemon pokemon;

	public RareCarte getRare() {
		return rare;
	}

	public Pokemon getPokemon() {
        return pokemon;
    }
}
