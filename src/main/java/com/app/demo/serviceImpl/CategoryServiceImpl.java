 package com.app.demo.serviceImpl;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.demo.exception.ResourceNotFoundException;
import com.app.demo.dto.CategoryDto;
import com.app.demo.entity.Category;
import com.app.demo.repository.CategoryRepo;
import com.app.demo.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired CategoryRepo crepo;
	@Autowired ModelMapper modelmapper;

	@Override
	public CategoryDto createCategory(CategoryDto cDto) {
	     Category categry=this.dtoToCategory(cDto);
		Category cato=this.crepo.save(categry);
		return this.categoryToDto(cato);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto cdto, Integer id) {
		
	Category	cate=this.crepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category","cid",id));
	
	cate.setTitle(cdto.getTitle());
	cate.setDescription(cdto.getDescription());
	
	Category updated= this.crepo.save(cate);
	CategoryDto cDto=this.categoryToDto(updated);
	
	
		return cDto;
	}

	@Override
	public List<CategoryDto> getCategory() {
		
		List<Category> category=this.crepo.findAll();
		List<CategoryDto> categoryDto=category.stream().map((cat)->this.categoryToDto(cat)).collect(Collectors.toList());
		return categoryDto; 
	}

	@Override
	public CategoryDto getCategoryById(Integer id) {
		// TODO Auto-generated ; stub
		Category categ= this.crepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "cid",id));
		
		return this.categoryToDto(categ);
	}

	@Override
	public void deleteCategory( Integer id) {
	    Category categ= this.crepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "cid",id));
	    		this.crepo.delete(categ);
	    
		
	}
	
	private Category dtoToCategory(CategoryDto cdto) {
		
		Category category=this.modelmapper.map(cdto,Category.class);
		return category; 
		}
	
	private CategoryDto categoryToDto(Category  category) {
		CategoryDto  cdto=this.modelmapper.map(category, CategoryDto.class);
		return cdto;
	}

}
