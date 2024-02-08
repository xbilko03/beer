package com.example.demo.dal;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BeerItem;

@Repository
public interface BeerItemRepository extends MongoRepository<BeerItem, String> {
}