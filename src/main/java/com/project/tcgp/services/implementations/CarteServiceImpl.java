package com.project.tcgp.services.implementations;

import com.project.tcgp.constants.RareCarte;
import com.project.tcgp.constants.TypePokemon;
import com.project.tcgp.dto.CreateCarte;
import com.project.tcgp.dto.CreatePokemon;
import com.project.tcgp.models.Carte;
import com.project.tcgp.models.Pokemon;
import com.project.tcgp.repositories.CarteRepository;
import com.project.tcgp.repositories.PokemonRepository;
import com.project.tcgp.services.ICarteService;
import com.project.tcgp.services.IPokemonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteServiceImpl implements ICarteService {

	private final CarteRepository repository;

	public CarteServiceImpl(CarteRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Carte> findAll(RareCarte rareCarte) {
		if(rareCarte == null) {
			return repository.findAll();
		}
		return repository.findAllByRare(rareCarte);
	}

	@Override
	public void create(CreateCarte createCarte) {
		Carte carteACreer = new Carte();
		carteACreer.setRare(createCarte.getRare());
		carteACreer.setPokemon(createCarte.getPokemon());
		repository.save(carteACreer);
	}

	@Override
	public Carte findById(String uuid) {
		// renvoie soit une carte soit null
		return repository.findById(uuid).orElse(null);
	}

	@Override
	public boolean update(String uuid, Carte carte) {
		Carte carteAModifier = findById(uuid);
		if(carteAModifier == null) {
			return false;
		}
		carteAModifier.setRare(carte.getRare());
		carteAModifier.setPokemon(carte.getPokemon());
		repository.save(carteAModifier);
		return true;
	}

	@Override
	public boolean delete(String uuid) {
		Carte carteAModifier = findById(uuid);
		if(carteAModifier == null) {
			return false;
		}
		repository.deleteById(uuid);
		return true;
	}
}
