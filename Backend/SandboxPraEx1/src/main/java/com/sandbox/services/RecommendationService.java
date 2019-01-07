package com.sandbox.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sandbox.models.Recommendation;
import com.sandbox.repositories.RecommendationRepository;

@Service
public class RecommendationService {

	@Autowired
	private RecommendationRepository recommendationRepository;
	
	// Get All Recommendation
	public List<Recommendation> getAllRecommendation(Long id){
		System.out.println("Get all Recommendations...");
		
		List<Recommendation> recommendations = new ArrayList<>();
		
		//recommendations = recommendationRepository.findByInquiryId(id);
		recommendations = recommendationRepository.findByInquiryIdOrderByIdDesc(id);
		
		return recommendations;
	}
	
	// Add recommendation
	public void addRecommendation(Recommendation newRecommendation) {
		recommendationRepository.save(newRecommendation);
	}
}
