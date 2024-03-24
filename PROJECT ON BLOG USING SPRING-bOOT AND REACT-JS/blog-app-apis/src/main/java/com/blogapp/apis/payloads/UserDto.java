package com.blogapp.apis.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
/*
 * this class can communicate with userService class and after all successful data 
 * it will goes to communicate with user class.
 */
public class UserDto {
	
	private int id;
	private String name;
	private String email;
	private String password;
	private String about;
	

}
