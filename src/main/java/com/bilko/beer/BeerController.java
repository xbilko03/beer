package com.bilko.beer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bilko.beer.model.BeerItem;
import com.bilko.beer.dal.BeerItemRepository;

@RestController
public class BeerController {
	private final BeerItemRepository beerRepository;
	
	public BeerController(BeerItemRepository beerRepository) {
		this.beerRepository = beerRepository;
	}
	
	/* Read beer list */
	@GetMapping("/beers")
	public List<BeerItem> getBeer() {
		return beerRepository.findAll();
	}

	/* Create new review */
	@PostMapping("beers/review/new")
	public BeerItem addReview(@RequestParam(value = "id") long beerID) {
		//todo
		return beerRepository.save(new BeerItem(beerID, "bucahc", "b", "c", "d", "e", "f", "g", "h", "i", "j"));
	}

	/* Read review */
	@GetMapping("beers/review/detail")
	public BeerItem readReview(@RequestParam(value = "id") long beerID) {
		//todo
		return beerRepository.save(new BeerItem(beerID, "bucahc", "b", "c", "d", "e", "f", "g", "h", "i", "j"));
	}

	/* Update review */
	@GetMapping("beers/review/edit")
	public BeerItem updateReview(@RequestParam(value = "id") long beerID) {
		//todo
		return beerRepository.save(new BeerItem(beerID, "bucahc", "b", "c", "d", "e", "f", "g", "h", "i", "j"));
	}

	/* Delete review */
	@GetMapping("beers/review/remove")
	public BeerItem deleteReview(@RequestParam(value = "id") long beerID) {
		//todo
		return beerRepository.save(new BeerItem(beerID, "bucahc", "b", "c", "d", "e", "f", "g", "h", "i", "j"));
	}

	/*
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	*/
}