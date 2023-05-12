package com.app.demo.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CategoryDto {
	
	private Integer id;

	private String title;

	private String description;

	
	
	

	public Integer getCategoryId() {
		return id;
	}

	public void setCategoryId(Integer categoryId) {
		this.id = categoryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	

}
