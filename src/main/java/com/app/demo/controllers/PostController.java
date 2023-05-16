package com.app.demo.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.apiResponce.ApiResponce;
import com.app.demo.dto.PostDto;
import com.app.demo.dto.PostResponse;
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
	
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
		List<PostDto> post=this.pservice.getAllPostByUser(userId);
		return new ResponseEntity<List<PostDto>>(post,HttpStatus.OK);
	}
	
	@GetMapping("/category/{cId}/posts")
	public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer cId){
		List<PostDto> post=this.pservice.getAllPostByCategory(cId);
		return new ResponseEntity<List<PostDto>>(post,HttpStatus.OK);
	}
	// to get parameter we use request param
	
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(@RequestParam(value="pageNumber",defaultValue="0",required=false) Integer pageNumber,
			@RequestParam(value="pageSize",defaultValue="10",required=false) Integer pageSize, 
			@RequestParam (value="sortBy", defaultValue =  "PostId",required = false) String sortBy){
		PostResponse prepo=this.pservice.getAllPost(pageNumber,pageSize,sortBy);
		return new ResponseEntity<PostResponse>(prepo,HttpStatus.OK);
	}
	
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable  Integer postId){
		PostDto pdto=this.pservice.getPostById(postId);
		return ResponseEntity.ok(pdto);
		
	}
	
	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<PostDto> deletePost(@PathVariable Integer postId){
		this.pservice.DeletePost(postId);
		
		return new  ResponseEntity(new ApiResponce("Post Deleted Succesfully",true),HttpStatus.OK);
		
		
	}
	
	@PutMapping("/post/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto pDto, @PathVariable Integer postId){
		PostDto pdto=this.pservice.updatePost(pDto, postId);
		return ResponseEntity.ok(pdto);
		
		
	}
	@GetMapping("/posts/search/{Keywords}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable String Keywords){
		List<PostDto> result=this.pservice.searchPosts(Keywords);
		return new ResponseEntity<List<PostDto>>(result,HttpStatus.OK);
		
	}

}
