package com.blogapp.apis.services;

import java.util.List;

import com.blogapp.apis.payloads.UserDto;

public interface UserService {
	// creating some method to performs operation on them
	
	UserDto createUser(UserDto user);
	
	UserDto updateUser(UserDto user,Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);

}
