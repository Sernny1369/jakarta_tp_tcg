package com.project.tcgp.repositories;

import com.project.tcgp.constants.TypePokemon;
import com.project.tcgp.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, String> {

	// SELECT * FROM pokemon WHERE type_pokemon = :type;
	List<Pokemon> findAllByType(TypePokemon type);
}
