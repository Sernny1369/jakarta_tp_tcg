package com.project.tcgp.controllers;

import com.project.tcgp.dto.TirageCarte;
import com.project.tcgp.services.ITirageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tirage")
public class TirageController {
    @Autowired
    private ITirageService tirageService;

    @GetMapping("/cartes")
    public List<TirageCarte> tirerCartes() {
        return tirageService.tirerCartes();
    }
}