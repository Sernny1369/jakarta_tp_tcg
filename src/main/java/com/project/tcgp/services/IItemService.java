package com.project.tcgp.services;

import com.project.tcgp.models.Item;

import java.util.List;

public interface IItemService {

	List<Item> findAll();

	Item findById(String uuid);

	void save(Item item);
}
