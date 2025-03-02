package com.project.tcgp.dto;

import com.project.tcgp.constants.TypePokemon;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public class CreatePokemon {

	@Length(min = 3, max = 20)
	private String nom;

	@Positive
	private Integer pv;

	private TypePokemon type;

	public String getNom() {
		return nom;
	}

	public Integer getPv() {
		return pv;
	}

	public TypePokemon getType() {
		return type;
	}
}
