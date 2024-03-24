package com.blogapp.apis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogapp.apis.payloads.UserDto;
import com.blogapp.apis.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	//post - for create a user
	
	@GetMapping("/ritik")
	public String getString() {
		return "hello ritik sharma";
	}
	/*
	 * here we are using the UserDto to transfere the data beacuse 
	 * to security perpuse we are not using the user class directly
	 * for that we had created two method to chang the data form 
	 * userDto class to user class
	 */
	@PostMapping("/user")
	public ResponseEntity<UserDto> creatUser(@RequestBody UserDto userDto){
		
		UserDto created_User = this.userService.createUser(userDto);
		// to send the client SMS
		return new ResponseEntity<>(created_User, HttpStatus.CREATED) ;
		
	}
	// put- for update a user
	
	// delete - for delete a user
	
	// get - to get a user

}
