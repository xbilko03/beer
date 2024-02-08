package com.bilko.beer.dal;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.ExistsQuery;
import org.springframework.stereotype.Repository;

import com.bilko.beer.model.ReviewItem;

@Repository
public interface ReviewItemRepository extends MongoRepository<ReviewItem, String> {
	@DeleteQuery
    void deleteById(long id);
	
	@ExistsQuery
    Optional<ReviewItem> findById(long beerID);
}