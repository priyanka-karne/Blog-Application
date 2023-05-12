package com.app.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.apiResponce.ApiResponce;
import com.app.demo.dto.CategoryDto;
import com.app.demo.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired CategoryService cserv;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto cdto){
		CategoryDto createDto= this.cserv.createCategory(cdto);
		return new ResponseEntity<CategoryDto>(createDto,HttpStatus.CREATED);
		
		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> updateDto(@Valid @RequestBody CategoryDto cdto , @PathVariable ("id") Integer cid){
		CategoryDto updaCategory=this.cserv.updateCategory(cdto, cid);
		return ResponseEntity.ok(updaCategory);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
	List<CategoryDto>	 getAllCate=this.cserv.getCategory();
	return ResponseEntity.ok(getAllCate);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable ("id") Integer cid){
		CategoryDto getcate=this.cserv.getCategoryById(cid);
		return ResponseEntity.ok(getcate);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CategoryDto> deleteCategory(@PathVariable ("id") Integer cid){
		this.cserv.deleteCategory(cid);
		return new ResponseEntity(new ApiResponce("Category Deleted Succesfully",true),HttpStatus.OK);
		
	}
	
	
	

}
