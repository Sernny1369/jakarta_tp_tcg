package com.project.tcgp.controllers;

import com.project.tcgp.models.Item;
import com.project.tcgp.services.IItemService;
import com.project.tcgp.services.implementations.ItemServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

	private final IItemService itemService;

	public ItemController(ItemServiceImpl itemService) {
		this.itemService = itemService;
	}

	@GetMapping
	public ResponseEntity<List<Item>> findAll() {
		return new ResponseEntity<>(itemService.findAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Item item) {
		itemService.save(item);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
