package com.example.demo.dal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BeerItem;

@Repository
public class BeerDALimp implements BeerDAL {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<BeerItem> getAllBeer() {
		return mongoTemplate.findAll(BeerItem.class);
	}

	@Override
	public BeerItem addBeer(BeerItem beer) {
		mongoTemplate.save(beer);
		// Now, user object will contain the ID as well
		return beer;
	}
}