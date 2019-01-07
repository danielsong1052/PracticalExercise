package com.sandbox.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sandbox.models.Recommendation;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {	
	//List<Recommendation> findByInquiryId(long id);
	List<Recommendation> findByInquiryIdOrderByIdDesc(long id);
}
