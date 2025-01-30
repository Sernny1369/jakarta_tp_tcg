package com.project.tcgp.dto;

import com.project.tcgp.constants.TypePokemon;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public class CapturePokemon {

	private String uuid;

	public String getUuid() {
		return uuid;
	}
}
