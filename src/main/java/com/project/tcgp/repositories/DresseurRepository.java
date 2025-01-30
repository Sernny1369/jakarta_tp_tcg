package com.project.tcgp.repositories;

import com.project.tcgp.models.Dresseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DresseurRepository extends JpaRepository<Dresseur, String> {
	List<Dresseur> findAllByDeletedAtNull();
}
