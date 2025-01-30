package com.project.tcgp.services.implementations;

import com.project.tcgp.models.Item;
import com.project.tcgp.repositories.ItemRepository;
import com.project.tcgp.services.IItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements IItemService {

	private final ItemRepository repository;

	public ItemServiceImpl(ItemRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Item> findAll() {
		return repository.findAll();
	}

	@Override
	public Item findById(String uuid) {
		return repository.findById(uuid).orElse(null);
	}

	@Override
	public void save(Item item) {
		repository.save(item);
	}
}
