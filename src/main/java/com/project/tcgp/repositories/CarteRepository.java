package com.project.tcgp.repositories;

import com.project.tcgp.constants.RareCarte;
import com.project.tcgp.models.Carte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarteRepository extends JpaRepository<Carte, String> {

	// SELECT * FROM carte WHERE rare_pokemon = :rare;
	List<Carte> findAllByRare(RareCarte rare);
}
