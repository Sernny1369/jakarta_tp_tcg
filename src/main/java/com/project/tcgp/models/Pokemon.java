package com.project.tcgp.models;

import com.project.tcgp.constants.TypePokemon;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;

	private String nom;

	private Integer niveau;

	@Enumerated(EnumType.STRING)
	private TypePokemon type;

	@OneToMany(mappedBy = "pokemon")
    private List<Carte> cartes;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNiveau() {
		return niveau;
	}

	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}

	public TypePokemon getType() {
		return type;
	}

	public void setType(TypePokemon type) {
		this.type = type;
	}

	public List<Carte> getCartes() {
        return cartes;
    }

    public void setCartes(List<Carte> cartes) {
        this.cartes = cartes;
    }


	public String getUuid() {
		return uuid;
	}
}
