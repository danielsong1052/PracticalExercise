package com.sandbox.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.models.Recommendation;
import com.sandbox.services.RecommendationService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class RecommendationController {

	@Autowired
	private RecommendationService recommendationService;
	
	// Get All Recommendation 
	@GetMapping(value="/recommendation/{id}")
	public List<Recommendation> getAllRecommendation(@PathVariable long id){
		List<Recommendation> recommendations = recommendationService.getAllRecommendation(id);
		return recommendations;
	}
	
	// Add Recommendation
	@PostMapping(value="/addRecommendation")
	public void addRecommendation(@RequestBody Recommendation newRecommendation) {
		recommendationService.addRecommendation(newRecommendation);
	}
}
