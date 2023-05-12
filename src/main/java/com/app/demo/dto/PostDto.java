package com.app.demo.dto;

import java.util.Date;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PostDto {
	
	
	private String title;
	
	private String content;
	
    private String imageNAme;
	
	private Date addedDate;
	
	
	private CategoryDto category;

	private UserDto user;


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageNAme() {
		return imageNAme;
	}

	public void setImageNAme(String imageNAme) {
		this.imageNAme = imageNAme;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}
	
	//private String imageNAme="defailt.png";
	
	
	
	
	
	

}
