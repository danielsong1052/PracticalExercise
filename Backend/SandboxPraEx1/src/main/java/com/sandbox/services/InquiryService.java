package com.sandbox.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.sandbox.models.Inquiry;
import com.sandbox.repositories.InquiryRepository;

@Service
public class InquiryService {

	@Autowired
	private InquiryRepository inquiryRepository;
	
	// All Inquiries
	public List<Inquiry> getAllInquiries() {
		System.out.println("Get all inquiries...");
		
		List<Inquiry> inquiries = new ArrayList<>();
		inquiryRepository.findAllByOrderByLastNameAsc().forEach(inquiries::add);		
		
		return inquiries;
	}
	
	// Get the inquiry
	public Inquiry getInquiry(long id) {
		Optional<Inquiry> inquiry = inquiryRepository.findById(id);
		if(inquiry.isPresent()) {
			return inquiry.get();
		}
		return null;
	}
	
	
	// Add Comment
	public void addInquiry(Inquiry newInquiry) {
		inquiryRepository.save(newInquiry);		
	}
	
}
