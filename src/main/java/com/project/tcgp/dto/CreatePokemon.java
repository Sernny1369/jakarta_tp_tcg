package com.project.tcgp.dto;

import com.project.tcgp.constants.TypePokemon;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public class CreatePokemon {

	@Length(min = 3, max = 20)
	private String nom;

	@Positive
	private Integer niveau;

	private TypePokemon type;

	public String getNom() {
		return nom;
	}

	public Integer getNiveau() {
		return niveau;
	}

	public TypePokemon getType() {
		return type;
	}
}
