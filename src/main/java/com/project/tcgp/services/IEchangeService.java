package com.project.tcgp.services;

import com.project.tcgp.models.Dresseur;

public interface IEchangeService {
    boolean peutEchanger(Dresseur dresseur1, Dresseur dresseur2);
    void echanger(Dresseur dresseur1, Dresseur dresseur2);
}