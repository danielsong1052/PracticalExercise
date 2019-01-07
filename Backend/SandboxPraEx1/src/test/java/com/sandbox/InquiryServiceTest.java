package com.sandbox;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sandbox.models.Inquiry;
import com.sandbox.services.InquiryService;
//import com.sandbox.services.InquiryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InquiryServiceTest {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private InquiryService inquiryService;
	
	@Test
	public void testGetAllInquiries() {
		List<Inquiry> inquiries = inquiryService.getAllInquiries();		
		
		for(Inquiry inquiry : inquiries) {
			logger.info("JUnit Test: " + inquiry.getEmail() + " " + inquiry.getLastName());
		}
	}
	
	@Test
	public void testAddInquiry() throws Exception {
		Inquiry inquiry = new Inquiry();
		inquiry.setFirstName("Junit firstName3");
		inquiry.setLastName("first lastName3");
		inquiry.setEmail("Junit3@gmail.com");
		inquiry.setComments("This is the test for Junit3");
		inquiry.setCreatedDate("2019-01-07 15:11:23");
		
		inquiryService.addInquiry(inquiry);
	}
}
