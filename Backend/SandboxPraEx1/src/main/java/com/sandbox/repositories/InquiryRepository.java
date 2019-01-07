package com.sandbox.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandbox.models.Inquiry;

public interface InquiryRepository extends JpaRepository<Inquiry, Long>{
	List<Inquiry> findAllByOrderByLastNameAsc();
}
