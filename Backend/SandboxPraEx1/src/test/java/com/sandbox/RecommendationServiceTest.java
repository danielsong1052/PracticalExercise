package com.sandbox;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sandbox.models.Recommendation;
import com.sandbox.services.RecommendationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecommendationServiceTest {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private RecommendationService recommendationService;
	
	@Test
	public void testGetAllRecommendations(){
		Long id = 96L;
		List<Recommendation> recommendations = recommendationService.getAllRecommendation(id);
		
		for(Recommendation rec : recommendations) {
			logger.info("JUnit Recommendation: "+rec.getCategory() +" "+rec.getComments());
		}		
	}
	
	@Test
	public void testAddRecommendation() {
		Recommendation rec = new Recommendation();
		Long inquiryId = 96L;
		rec.setInquiryId(inquiryId);
		rec.setCategory("business");
		rec.setComments("This is the Junit Recommendation");
		rec.setCreatedDate("2019-01-07 15:11:23");
		
		recommendationService.addRecommendation(rec);
	}
	

}
