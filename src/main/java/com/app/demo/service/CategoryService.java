package com.app.demo.service;

import java.util.List;

import com.app.demo.dto.CategoryDto;

public interface CategoryService {
	
	// create
	public CategoryDto createCategory(CategoryDto cDto);
	
	//update
	public CategoryDto updateCategory(CategoryDto cdto, Integer id);
	
	
	// get
	public List<CategoryDto> getCategory();
	
	public CategoryDto getCategoryById(Integer id);
	
	
	
	
	//delete
	public void deleteCategory( Integer id);

}
