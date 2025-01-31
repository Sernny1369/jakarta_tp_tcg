package com.project.tcgp.repositories;

import com.project.tcgp.models.Dresseur;
import com.project.tcgp.models.Echange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface EchangeRepository extends JpaRepository<Echange, Long> {
    Optional<Echange> findByDresseur1AndDresseur2AndDateEchangeBetween(Dresseur dresseur1, Dresseur dresseur2, LocalDateTime start, LocalDateTime end);
}