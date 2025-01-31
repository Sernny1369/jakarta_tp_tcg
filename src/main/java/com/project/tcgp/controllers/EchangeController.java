package com.project.tcgp.controllers;

import com.project.tcgp.dto.EchangeCarte;
import com.project.tcgp.services.IEchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/echange")
public class EchangeController {
    private final IEchangeService echangeService;

    @Autowired
    public EchangeController(IEchangeService echangeService) {
        this.echangeService = echangeService;
    }

    @PostMapping
    public void echangerCartes(@RequestBody EchangeCarte echangeCarte) {
        echangeService.echanger(echangeCarte);
    }
}