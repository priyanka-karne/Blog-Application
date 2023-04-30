package com.app.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.demo.dto.UserDto;
import com.app.demo.entity.User;
import com.app.demo.exception.*;
import com.app.demo.repository.UserRepo;
import com.app.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelmapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		User user=this.dtoToUser(userDto);
		 User userSaved=this.userRepo.save(user);
		return this.UseryToDto(userSaved);
	}

	@Override
	public UserDto updateUser(UserDto userdt, Integer userId) {
		 User user= this.userRepo.findById(userId)
				 .orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
		
		 user.setName(userdt.getName());
		 user.setEmail(userdt.getEmail());
		 user.setPassword(userdt.getPassword());
		 user.setAbout(userdt.getAbout());
		 
		 User updateUser=(this.userRepo.save(user));
		UserDto udt1= this.UseryToDto(updateUser);
		return udt1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
	
		 User Userfind=this.userRepo.findById(userId)
				 .orElseThrow(()-> new ResourceNotFoundException("User","id",userId));;
		 
		return this.UseryToDto(Userfind);
	}

	@Override
	public List<UserDto> getAllUser() {
		
	List<User> users=	this.userRepo.findAll();
	List<UserDto> udt=users.stream().map(user->this.UseryToDto(user)).collect(Collectors.toList()); 
		
		return udt;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
	User user=	this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
    this.userRepo.delete(user);
	}
	
	
	private User  dtoToUser(UserDto userDto) {
		
		User user= this.modelmapper.map(userDto, User.class);
//		User user  = new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		
		return user;
		
		 
		
	}
	
	public UserDto  UseryToDto(User user) {
		UserDto userdt=this.modelmapper.map(user, UserDto.class);
		
//		UserDto userdt  = new UserDto();
//		userdt.setId(user.getId());
//		userdt.setName(user.getName());
//		userdt.setEmail(user.getEmail());
//		userdt.setPassword(user.getPassword());
//		userdt.setAbout(user.getAbout());
		
		return userdt;
		
		 
		
	}

}
