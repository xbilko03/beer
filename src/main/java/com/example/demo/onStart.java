package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.core.ParameterizedTypeReference;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.demo.model.BeerItem;
import com.example.demo.dal.BeerItemRepository;

@SpringBootApplication
public class onStart {
	
	private final BeerItemRepository beerRepository;
	public onStart(BeerItemRepository beerRepository) {
		this.beerRepository = beerRepository;
	}


   @Autowired
   RestTemplate restTemplate;
   

@EventListener(ApplicationReadyEvent.class)
   public void onStartEvent() {

	/* if there is no beer in database, load and save it */
	if(beerRepository.findAll().isEmpty() == true)
	{		
	   HttpHeaders headers = new HttpHeaders();
	   headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	   HttpEntity <String> entity = new HttpEntity<String>(headers);
	   
	ResponseEntity<List<BeerItem>> beerResponse =
	restTemplate.exchange("https://random-data-api.com/api/v2/beers?size=100",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<BeerItem>>() {
            });
	List<BeerItem> beers = beerResponse.getBody();

		for (int i = 0; i < beers.size(); i++)
		{
		BeerItem cBeer = beers.get(i);
		beerRepository.save(
		new BeerItem(i, 
		cBeer.getUID(), 
		cBeer.getBrand(), 
		cBeer.getName(), 
		cBeer.getStyle(), 
		cBeer.getHop(),
		cBeer.getYeast(),
		cBeer.getMalts(),
		cBeer.getIbu(),
		cBeer.getAlcohol(),
		cBeer.getBlg() ) );
		}
	}


	}
}
