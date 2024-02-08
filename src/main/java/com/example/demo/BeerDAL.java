package com.example.demo.dal;

import java.util.List;

import com.example.demo.model.BeerItem;

public interface BeerDAL {

	List<BeerItem> getAllBeer();

	BeerItem addBeer(BeerItem beer);

}