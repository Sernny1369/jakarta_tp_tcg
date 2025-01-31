package com.project.tcgp.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Echange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Dresseur dresseur1;

    @ManyToOne
    private Dresseur dresseur2;

    private LocalDateTime dateEchange;

    // Getters and setters
}