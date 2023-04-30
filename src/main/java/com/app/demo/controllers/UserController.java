package com.app.demo.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.apiResponce.ApiResponce;
import com.app.demo.dto.UserDto;
import com.app.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService uservice;
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDtto ){
		UserDto createdUDto=this.uservice.createUser(userDtto);
		return new ResponseEntity<UserDto>(createdUDto,HttpStatus.CREATED);
		
	}
	
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUSer(@Valid @RequestBody UserDto udto , @PathVariable ("userId") Integer uId){
		UserDto updateUser = this.uservice.updateUser(udto, uId);
		return ResponseEntity.ok(updateUser);
	}
	
//	@DeleteMapping("/{userId}")
//	public ResponseEntity< ?> deleteUSer(@PathVariable ("userId") Integer uId){
//		this.uservice.deleteUser(uId);
//		
//		return new ResponseEntity(Map.of("message","user Deleted succesfully"),HttpStatus.OK);
//		
//	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity< ApiResponce> deleteUSer(@PathVariable ("userId") Integer uId){
		this.uservice.deleteUser(uId);
		
		return new ResponseEntity(new ApiResponce("User Deleted Succesfully",true),HttpStatus.OK);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser(){
		List<UserDto> allUser = this.uservice.getAllUser();
		return   ResponseEntity.ok(allUser);
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUser( @PathVariable("userId") Integer uid  ){
		UserDto user =this.uservice.getUserById(uid);
		
		return ResponseEntity.ok(user);
	}

}
