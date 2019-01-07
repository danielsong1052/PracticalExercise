package com.sandbox.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="categoryNo")
	private int categoryNo;
	
	@Column(name="categoryName")
	private String categoryName;	
	
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Long getId() {
		return id;
	}
	
	public Category() {}
	
	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryNo=" + categoryNo + ", categoryName=" + categoryName + "]";
	}
	
	
}
