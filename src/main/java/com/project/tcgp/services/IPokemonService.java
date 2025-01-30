package com.project.tcgp.services;

import com.project.tcgp.constants.TypePokemon;
import com.project.tcgp.controllers.PokemonController;
import com.project.tcgp.dto.CreatePokemon;
import com.project.tcgp.models.Pokemon;

import java.util.List;

public interface IPokemonService {

	List<Pokemon> findAll(TypePokemon type);

	Pokemon findById(String uuid);

	void create(CreatePokemon pokemon);

	boolean update(String uuid, Pokemon pokemon);

	boolean delete(String uuid);
}
