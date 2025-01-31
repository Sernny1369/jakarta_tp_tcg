package com.project.tcgp.services.impl;

import com.project.tcgp.dto.EchangeCarte;
import com.project.tcgp.models.Dresseur;
import com.project.tcgp.models.Echange;
import com.project.tcgp.repositories.DresseurRepository;
import com.project.tcgp.repositories.EchangeRepository;
import com.project.tcgp.services.IEchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class EchangeServiceImpl implements IEchangeService {
    private final EchangeRepository echangeRepository;
    private final DresseurRepository dresseurRepository;

    @Autowired
    public EchangeServiceImpl(EchangeRepository echangeRepository, DresseurRepository dresseurRepository) {
        this.echangeRepository = echangeRepository;
        this.dresseurRepository = dresseurRepository;
    }

    @Override
    public boolean peutEchanger(Long dresseur1Id, Long dresseur2Id) {
        LocalDateTime startOfDay = LocalDateTime.now().with(LocalTime.MIN);
        LocalDateTime endOfDay = LocalDateTime.now().with(LocalTime.MAX);
        Optional<Echange> echange = echangeRepository.findByDresseur1AndDresseur2AndDateEchangeBetween(
                dresseurRepository.findById(dresseur1Id).orElseThrow(() -> new IllegalArgumentException("Dresseur 1 non trouvé")),
                dresseurRepository.findById(dresseur2Id).orElseThrow(() -> new IllegalArgumentException("Dresseur 2 non trouvé")),
                startOfDay, endOfDay);
        return echange.isEmpty();
    }

    @Override
    public void echanger(EchangeCarte echangeCarte) {
        Dresseur dresseur1 = dresseurRepository.findById(Long.parseLong(echangeCarte.getDresseur1Id()))
                .orElseThrow(() -> new IllegalArgumentException("Dresseur 1 non trouvé"));
        Dresseur dresseur2 = dresseurRepository.findById(Long.parseLong(echangeCarte.getDresseur2Id()))
                .orElseThrow(() -> new IllegalArgumentException("Dresseur 2 non trouvé"));

        if (peutEchanger(dresseur1.getId(), dresseur2.getId())) {
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