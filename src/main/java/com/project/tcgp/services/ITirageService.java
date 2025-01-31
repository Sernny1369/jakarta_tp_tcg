package com.project.tcgp.services;

import com.project.tcgp.models.Carte;

import java.util.List;

public interface ITirageService {
    List<Carte> tirerCartes();
}