package com.app.demo.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import lombok.NoArgsConstructor;

@Entity
@Table(name="post")
@NoArgsConstructor
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="post_title",length=100,nullable=false)
	private String title;
	@Column(name="post_content",length=1000,nullable=false)
	private String content;
	
	private String imageNAme;
	
	private Date addedDate;
	
	@ManyToOne
	private Category category;
	@ManyToOne
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
	
	

}
