package com.example.demo;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
class ItemsController {

	private final ItemRepository repository = new ItemRepository();

	@RequestMapping(path = "/items", method = GET)
	public Flux<Item> list() {
	  return repository.all();
	}

	@RequestMapping(path = "/items", method = POST)
	public Flux<Boolean> add(@RequestBody Flux<Item> newItems) {
	  return repository.save(newItems);
	}
}
