package com.bilko.beer.bal;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bilko.beer.model.BeerItem;
import com.bilko.beer.model.ReviewItem;
import com.bilko.beer.dal.BeerItemRepository;
import com.bilko.beer.dal.ReviewItemRepository;

/* Exposes the REST API operations */
@RestController
public class BeerController {
	private final BeerItemRepository beerRepository;
	private final ReviewItemRepository reviewRepository;
	
	public BeerController(BeerItemRepository beerRepository, ReviewItemRepository reviewRepository) {
		this.beerRepository = beerRepository;
		this.reviewRepository = reviewRepository;
	}
	
	/* Read beer list */
	@GetMapping("/beers")
	public List<BeerItem> getBeer() {
		return beerRepository.findAll();
	}

	/* Create new review */
	@PostMapping("beers/review/new")
	public ReviewItem addReview(@RequestParam(value = "id") long beerID, @RequestParam(value = "rating") long rating, @RequestParam(value = "text") String text) {
		return reviewRepository.save(new ReviewItem(beerID, rating, text));
	}

	/* Read review */
	@GetMapping("beers/review")
	public Optional<ReviewItem> readReviewId(@RequestParam(value = "id") long beerID) {
		return reviewRepository.findById(beerID);
	}

	/* Update review */
	@PostMapping("beers/review/edit")
	public ReviewItem updateReview(@RequestParam(value = "id") long beerID, @RequestParam(value = "rating") long rating, @RequestParam(value = "text") String text) {
		return reviewRepository.save(new ReviewItem(beerID, rating, text));
	}

	/* Delete review */
	@DeleteMapping("beers/review/remove")
	public void deleteReview(@RequestParam(value = "id") long beerID) {
		reviewRepository.deleteById(beerID);
	}
}