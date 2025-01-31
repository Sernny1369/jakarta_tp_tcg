package com.project.tcgp.services.impl;

import com.project.tcgp.models.Dresseur;
import com.project.tcgp.models.Echange;
import com.project.tcgp.repositories.EchangeRepository;
import com.project.tcgp.services.IEchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class EchangeServiceImpl implements IEchangeService {
    @Autowired
    private EchangeRepository echangeRepository;

    @Override
    public boolean peutEchanger(Dresseur dresseur1, Dresseur dresseur2) {
        LocalDateTime startOfDay = LocalDateTime.now().with(LocalTime.MIN);
        LocalDateTime endOfDay = LocalDateTime.now().with(LocalTime.MAX);
        Optional<Echange> echange = echangeRepository.findByDresseur1AndDresseur2AndDateEchangeBetween(dresseur1, dresseur2, startOfDay, endOfDay);
        return echange.isEmpty();
    }

    @Override
    public void echanger(Dresseur dresseur1, Dresseur dresseur2) {
        if (peutEchanger(dresseur1, dresseur2)) {
            Echange echange = new Echange();
            echange.setDresseur1(dresseur1);
            echange.setDresseur2(dresseur2);
            echange.setDateEchange(LocalDateTime.now());
            echangeRepository.save(echange);
        } else {
            throw new IllegalStateException("Les dresseurs ont déjà échangé des cartes aujourd'hui.");
        }
    }
}