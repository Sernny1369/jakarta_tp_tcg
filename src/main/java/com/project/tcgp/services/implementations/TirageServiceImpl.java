package com.project.tcgp.services.impl;

import com.project.tcgp.constants.RareCarte;
import com.project.tcgp.dto.TirageCarte;
import com.project.tcgp.models.Carte;
import com.project.tcgp.models.Pokemon;
import com.project.tcgp.repositories.CarteRepository;
import com.project.tcgp.services.ITirageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TirageServiceImpl implements ITirageService {
    @Autowired
    private CarteRepository carteRepository;

    private static final String[] POKEMON_NAMES = {"Pikachu", "Bulbasaur", "Charmander", "Squirtle", "Eevee"};

    @Override
    public List<TirageCarte> tirerCartes() {
        List<TirageCarte> cartesDTO = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            Carte carte = new Carte();
            Pokemon pokemon = new Pokemon();
            pokemon.setNom(POKEMON_NAMES[random.nextInt(POKEMON_NAMES.length)]);
            carte.setPokemon(pokemon);
            carte.setRare(genererRarete(random));
            carte = carteRepository.save(carte);

            TirageCarte carteDTO = new TirageCarte();
            carteDTO.setUuid(carte.getUuid());
            carteDTO.setNomPokemon(carte.getPokemon().getNom());
            carteDTO.setRare(carte.getRare());
            cartesDTO.add(carteDTO);
        }

        return cartesDTO;
    }

    private RareCarte genererRarete(Random random) {
        int rarete = random.nextInt(100) + 1;
        if (rarete <= 50) return RareCarte.COMMUN;
        if (rarete <= 75) return RareCarte.INHABITUEL;
        if (rarete <= 90) return RareCarte.RARE;
        if (rarete <= 98) return RareCarte.EPIQUE;
        return RareCarte.LEGENDAIRE;
    }
}