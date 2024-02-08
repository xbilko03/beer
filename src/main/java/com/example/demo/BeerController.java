package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dal.BeerItemRepository;
import com.example.demo.model.BeerItem;
import java.util.List;


@RestController
public class BeerController {

	private final AtomicLong counter = new AtomicLong();
	

	private final BeerItemRepository beerRepository;
	
	public BeerController(BeerItemRepository beerRepository) {
		this.beerRepository = beerRepository;
	}
	
	@GetMapping("/beers")
	public List<BeerItem> getBeer() {
		return beerRepository.findAll();
	}


	@PostMapping("/addmongo")
	public BeerItem addBeer() {
		return beerRepository.save(new BeerItem(60, "bucahc", "b", "c", "d", "e", "f", "g", "h", "i", "j"));
	}



	@PostMapping("/review")
	public NewReview review() {


		return new NewReview(counter.incrementAndGet(),0, 0,"abc");
	}
	@GetMapping("/beer")
	public Beer beer() {
		return new Beer(counter.incrementAndGet());
	}
	@PutMapping("/edit")
	public EditReview edit() {
		return new EditReview(counter.incrementAndGet(),0, 0,"abc");
	}
	@DeleteMapping("/delete")
	public DeleteReview delete(@RequestParam(value = "id") long beerID) {
		return new DeleteReview(counter.incrementAndGet(), beerID);
	}
	/*
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	*/
}