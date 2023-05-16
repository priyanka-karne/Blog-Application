package com.app.demo.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.app.demo.dto.PostDto;
import com.app.demo.dto.PostResponse;
import com.app.demo.entity.Category;
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
		Post post=this.postRepo.findById(Postid).orElseThrow(()-> new ResourceNotFoundException("Post", "id", Postid));
		
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageNAme(postDto.getImageNAme());
		
		Post updatedPost=this.postRepo.save(post);
		
		return this.modelmapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void DeletePost(Integer Postid) {
		Post post=this.postRepo.findById(Postid).orElseThrow(()-> new ResourceNotFoundException("Post", "id", Postid));
		this.postRepo.delete(post);

	}

	@Override
	public PostResponse getAllPost(Integer pageNumber , Integer pageSize , String sortBy) {
		
		
		Pageable p=PageRequest.of(pageNumber, pageSize,Sort.by(sortBy));
		
	      Page<Post> pagePost=this.postRepo.findAll(p);
	      List<Post> post=pagePost.getContent();
	      List<PostDto> pdto=post.stream().map((pos)->this.modelmapper.map(pos, PostDto.class)).collect(Collectors.toList());
	      
	      PostResponse presp= new PostResponse();
	      presp.setContent(pdto);
	      presp.setPageNumber(pagePost.getNumber());
	      presp.setPageSize(pagePost.getSize());
	      presp.setTotalElements(pagePost.getTotalElements());
	      presp.setTotalPage(pagePost.getTotalPages());
	      presp.setLastPage(pagePost.isLast());
	      
	      
		return presp;
	}

	@Override
	public PostDto getPostById(Integer Postid) {
		Post post=this.postRepo.findById(Postid).orElseThrow(()-> new ResourceNotFoundException("Post", "id", Postid));
		
		PostDto pdto=this.modelmapper.map(post, PostDto.class);
		return pdto;
	}

	@Override
	public List<PostDto> getAllPostByCategory(Integer catregoryId) {
		Category categ=this.caterepo.findById(catregoryId).orElseThrow(()-> new ResourceNotFoundException("Category","Id",catregoryId));
		List<Post> post=this.postRepo.findByCategory(categ);
		
		List<PostDto> postDto=		post.stream().map((pos)->this.modelmapper.map(pos,PostDto.class)).collect(Collectors.toList());
		
		
		return postDto;
	}

	@Override
	public List<PostDto> getAllPostByUser(Integer userId) {
		User user=this.urepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "uid", userId));
		List<Post> post= this.postRepo.findByUser(user);
		
		List<PostDto> postDto=post.stream().map((cat)->this.modelmapper.map(cat, PostDto.class)).collect(Collectors.toList());
		return postDto;
	}

	@Override
	public List<PostDto> searchPosts(String keywords) {
		
		
		return null;
	}

}
