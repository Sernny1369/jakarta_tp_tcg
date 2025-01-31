package com.project.tcgp.controllers;

import com.project.tcgp.models.Dresseur;
import com.project.tcgp.services.DresseurService;
import com.project.tcgp.services.IEchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/echange")
public class EchangeController {
    @Autowired
    private IEchangeService echangeService;

    @Autowired
    private DresseurService dresseurService;

    @PostMapping("/{dresseur1Id}/{dresseur2Id}")
    public void echangerCartes(@PathVariable Long dresseur1Id, @PathVariable Long dresseur2Id) {
        Dresseur dresseur1 = dresseurService.findById(dresseur1Id);
        Dresseur dresseur2 = dresseurService.findById(dresseur2Id);
        echangeService.echanger(dresseur1, dresseur2);
    }
}