package com.sandbox.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandbox.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
