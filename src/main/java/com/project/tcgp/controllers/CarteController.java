package com.project.tcgp.controllers;

import com.project.tcgp.constants.RareCarte;
import com.project.tcgp.dto.CreateCarte;
import com.project.tcgp.models.Carte;
import com.project.tcgp.services.ICarteService;
import com.project.tcgp.services.implementations.CarteServiceImpl;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartes")
public class CarteController {
	private final ICarteService carteService;

	public CarteController(CarteServiceImpl carteService) {
		this.carteService = carteService;
	}

	@GetMapping
	public ResponseEntity<List<Carte>> getAll(@RequestParam(required = false) RareCarte rare) {
		// SELECT * from pokemon;
		return new ResponseEntity<>(carteService.findAll(rare), HttpStatus.OK);
	}

	@GetMapping("/{uuid}")
	public ResponseEntity<Carte> getById(@PathVariable String uuid) {
		Carte carte = carteService.findById(uuid);
		if(carte == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(carteService.findById(uuid), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> createcarte(@Valid @RequestBody CreateCarte carte) {
		// INSERT INTO carte (rare, pokmemon id) VALUES (carte.getNom(), carte.getNiveau(), carte.getType());
		carteService.create(carte);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/{uuid}")
	public ResponseEntity<?> updateCarte(@PathVariable String uuid, @RequestBody Carte carte) {
		boolean isModifier = carteService.update(uuid, carte);
		if(!isModifier) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/{uuid}")
	public ResponseEntity<?> updateCarte(@PathVariable String uuid) {
		boolean isSupprimer = carteService.delete(uuid);
		if(!isSupprimer) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
