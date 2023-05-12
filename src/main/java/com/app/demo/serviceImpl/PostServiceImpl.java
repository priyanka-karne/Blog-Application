package com.app.demo.serviceImpl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.demo.entity.Category;
import com.app.demo.dto.PostDto;
import com.app.demo.entity.Post;
import com.app.demo.entity.User;
import com.app.demo.exception.ResourceNotFoundException;
import com.app.demo.repository.CategoryRepo;
import com.app.demo.repository.PostRepo;
import com.app.demo.repository.UserRepo;
import com.app.demo.service.PostService;
@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired 
	private UserRepo urepo;
	
	@Autowired
	private CategoryRepo caterepo;
	
	@Override
	public PostDto createPost(PostDto postDto ,  Integer userId , Integer categoryId) {
		
		User user=this.urepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","userid", userId));
		Category category=this.caterepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryid", categoryId));
	
		Post post= this.modelmapper.map(postDto, Post.class);
		post.setImageNAme("Default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		Post newPost= this.postRepo.save(post);
		 
		
		
		
		return this.modelmapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer Postid) {

		return null;
	}

	@Override
	public void DeletePost(Integer Postid) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PostDto> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto getPostById(Integer Postid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getAllPostByCategory(Integer catregoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getAllPostByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> searchPosts(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}

}
