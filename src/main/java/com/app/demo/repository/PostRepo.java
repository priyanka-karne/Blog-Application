package com.app.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.demo.entity.Category;
import com.app.demo.entity.Post;
import com.app.demo.entity.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	public List<Post> findByUser(User user);
	
	public List<Post> findByCategory(Category category);

}
