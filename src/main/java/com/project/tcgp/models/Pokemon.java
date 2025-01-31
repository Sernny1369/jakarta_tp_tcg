package com.project.tcgp.models;

import com.project.tcgp.constants.TypePokemon;
import java.util.List;
import java.util.Random;

import jakarta.persistence.*;

@Entity
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;

	private String nom;

	private Integer pv;

	@Enumerated(EnumType.STRING)
	private TypePokemon type;

	private Integer atk1;
	private Integer atk2;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getPv() {
		return pv;
	}

	public void setPv(Integer pv) {
		this.pv = pv;
	}

	public TypePokemon getType() {
		return type;
	}

	public void setType(TypePokemon type) {
		this.type = type;
	}
	
	public Integer getAtk1() {
		return atk1;
	}

	public void setAtk1(Integer atk1) {
		this.atk1 = atk1;
	}
	public Integer getAtk2() {
		return atk2;
	}

	public void setAtk2(Integer atk2) {
		this.atk2 = atk2;
	}


	public String getUuid() {
		return uuid;
	}

	public void initializeStats() {
		Random random = new Random();
		this.atk1 = (random.nextInt(12) + 1) * 10; 
		this.atk2 = (random.nextInt(12) + 1) * 10; 
		this.pv = (random.nextInt(9) + 5) * 10; 
    }
}
