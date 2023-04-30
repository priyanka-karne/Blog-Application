package com.app.demo.service;

import java.util.List;

import com.app.demo.dto.UserDto;

public interface UserService {
	
	// for data transfer we use userDto
	
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user,Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUser();
    
    void deleteUser(Integer userId);
    
}
