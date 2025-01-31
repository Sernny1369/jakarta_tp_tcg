package com.project.tcgp.services.implementations;

import com.project.tcgp.constants.TypePokemon;
import com.project.tcgp.dto.CreatePokemon;
import com.project.tcgp.models.Pokemon;
import com.project.tcgp.repositories.PokemonRepository;
import com.project.tcgp.services.IPokemonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServiceImpl implements IPokemonService {

	private final PokemonRepository repository;

	public PokemonServiceImpl(PokemonRepository repository) {
		this.repository = repository;
	}

	
	@Override
	public List<Pokemon> findAll(TypePokemon typePokemon) {
		if(typePokemon == null) {
			return repository.findAll();
		}
		return repository.findAllByType(typePokemon);
	}

	@Override
	public void create(CreatePokemon pokemon) {
		Pokemon pokemonACreer = new Pokemon();
		pokemonACreer.setType(pokemon.getType());
		pokemonACreer.setNom(pokemon.getNom());
		pokemonACreer.setNiveau(pokemon.getNiveau());
		repository.save(pokemonACreer);
	}

	@Override
	public Pokemon findById(String uuid) {
		// renvoie soit un pokemon soit null
		return repository.findById(uuid).orElse(null);
	}

	@Override
	public boolean update(String uuid, Pokemon pokemon) {
		Pokemon pokemonAModifier = findById(uuid);
		if(pokemonAModifier == null) {
			return false;
		}
		pokemonAModifier.setNom(pokemon.getNom());
		pokemonAModifier.setNiveau(pokemon.getNiveau());
		pokemonAModifier.setType(pokemon.getType());
		repository.save(pokemonAModifier);
		return true;
	}

	@Override
	public boolean delete(String uuid) {
		Pokemon pokemonAModifier = findById(uuid);
		if(pokemonAModifier == null) {
			return false;
		}
		repository.deleteById(uuid);
		return true;
	}
}
