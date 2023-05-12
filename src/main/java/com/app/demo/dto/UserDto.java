package com.app.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


import lombok.NoArgsConstructor;

@NoArgsConstructor

public class UserDto {
	
	
	private int id;
	@NotEmpty
	@Size(min=5,message="User name min length must be 5")
	private String name;
	@NotEmpty
	@Email(message="Email id is not valid")
	private String email;
	@NotEmpty
	@Size(min=3,max=10,message="Password must be min of 3 char and max of 10 characters")
	
	private String password;
	@NotEmpty
	@Size(min = 20,message="About must me minimum 20 characters")
	private String about;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	

}
