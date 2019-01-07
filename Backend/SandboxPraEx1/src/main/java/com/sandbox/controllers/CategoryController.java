package com.sandbox.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandbox.models.Category;
import com.sandbox.services.CategoryService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value="/category")
	public List<Category> getAllCategory(){		
		List<Category> categories = categoryService.getAllCategories();
		return categories;
	}
	
}
