package com.project.tcgp.services;

import com.project.tcgp.constants.RareCarte;
import com.project.tcgp.controllers.PokemonController;
import com.project.tcgp.models.Carte;
import com.project.tcgp.dto.CreateCarte;


import java.util.List;

public interface ICarteService {

	List<Carte> findAll(RareCarte type);

	Carte findById(String uuid);

	void create(CreateCarte Carte);

	boolean update(String uuid, Carte carte);

	boolean delete(String uuid);
}
