package com.sandbox.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.models.Inquiry;
import com.sandbox.services.InquiryService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class InquiryController{

	@Autowired
	private InquiryService inquiryService;
	
	// Get All Inquiries
	@GetMapping(value="/inquiry")
	public List<Inquiry> getAllInquiries(){
		List<Inquiry> inquiries = inquiryService.getAllInquiries();		
		return inquiries;
	}
	
	@GetMapping(value="/inquiry/{id}")
	public Inquiry getInquiry(@PathVariable long id) {
		Inquiry inquiry = inquiryService.getInquiry(id);
		return inquiry;
	}
	
	// Add Inquiry
	@PostMapping(value="/addInquiry")
	public void addInquiry(@RequestBody Inquiry newInquiry) {
		System.out.println("newInquiry: "+newInquiry);
		inquiryService.addInquiry(newInquiry);
	}
}
