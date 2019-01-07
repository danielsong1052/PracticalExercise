package com.sandbox;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sandbox.models.Category;
import com.sandbox.services.CategoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CategoryService categoryService;
	
	@Test
	public void testGetCategories() {
		List<Category> categories = categoryService.getAllCategories();
		
		for(Category ca : categories) {
			logger.info("Junit Categories: " + ca.getCategoryNo() +" "+ ca.getCategoryName());
		}
	}
}
