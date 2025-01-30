package com.project.tcgp.repositories;

import com.project.tcgp.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, String> {
}
