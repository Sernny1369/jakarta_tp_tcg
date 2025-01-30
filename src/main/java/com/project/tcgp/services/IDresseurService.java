package com.project.tcgp.services;

import com.project.tcgp.dto.CapturePokemon;
import com.project.tcgp.dto.DresseurDTO;
import com.project.tcgp.models.Dresseur;

import java.util.List;

public interface IDresseurService {

	List<Dresseur> findAll();
	Dresseur findById(String uuid);
	void create(DresseurDTO dresseurDTO);

	boolean update(String uuid, DresseurDTO dresseurDTO);
	boolean delete(String uuid);

	void capturerPokemon(String uuid, CapturePokemon capturePokemon);
}
