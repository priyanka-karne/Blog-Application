package com.app.demo.service;

import java.util.List;

import com.app.demo.dto.PostDto;
import com.app.demo.dto.PostResponse;
import com.app.demo.entity.Post;

public interface PostService {
	
	public  PostDto createPost(PostDto postDto , Integer userId , Integer categoryId );
	
	public PostDto updatePost(PostDto postDto , Integer Postid);
	
	public void DeletePost(Integer Postid);
	
	
	public PostResponse getAllPost(Integer pageNumber , Integer pageSize, String sortBy);
	
	public PostDto getPostById(Integer Postid);
	
	public List<PostDto> getAllPostByCategory(Integer catregoryId);
	
	public List<PostDto> getAllPostByUser(Integer userId);
	
	
	public List<PostDto> searchPosts(String keywords);

}
