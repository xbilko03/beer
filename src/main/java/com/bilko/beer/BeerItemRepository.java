package com.bilko.beer.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bilko.beer.model.BeerItem;

@Repository
public interface BeerItemRepository extends MongoRepository<BeerItem, String> {
}