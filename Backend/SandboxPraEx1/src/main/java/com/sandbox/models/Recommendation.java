package com.sandbox.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="recommendation")
public class Recommendation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="inquiryId")
	private Long inquiryId;
	
	@Column(name="category")
	private String category;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="createdDate")
	private String createdDate;

	public Long getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(Long inquiryId) {
		this.inquiryId = inquiryId;
	}	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}
	
	public Recommendation() {}

	@Override
	public String toString() {
		return "Recommendation [id=" + id + ", inquiryId=" + inquiryId + ", category=" + category + ", comments="
				+ comments + ", createdDate=" + createdDate + "]";
	}
	
}
