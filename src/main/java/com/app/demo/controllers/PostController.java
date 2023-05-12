package com.app.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.dto.PostDto;
import com.app.demo.entity.Post;
import com.app.demo.service.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService pservice;
	
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto pdto, @PathVariable Integer userId, @PathVariable Integer categoryId){
		PostDto createdPost= this.pservice.createPost(pdto, userId, categoryId);
		
		return new ResponseEntity<PostDto>(createdPost,HttpStatus.CREATED);
		
	}

}
