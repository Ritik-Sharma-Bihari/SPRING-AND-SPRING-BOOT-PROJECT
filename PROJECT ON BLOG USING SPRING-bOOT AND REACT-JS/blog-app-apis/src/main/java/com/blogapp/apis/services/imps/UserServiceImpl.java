package com.blogapp.apis.services.imps;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blogapp.apis.entities.User;
import com.blogapp.apis.payloads.UserDto;
import com.blogapp.apis.repositories.UserRepo;
import com.blogapp.apis.services.UserService;
import com.blogapp.apis.exceptions.ResourceNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		/*
		 * after creating the dtoTOUser() and userToDto() to
		 * convert the userDto data to user and user to userDto
		 */
		User user = this.dtoTOUser(userDto);
		User savedUser = this.userRepo.save(user);	
		System.out.println("password at save time "+user.getPassword());
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		// TODO Auto-generated method stub
		/*
		 * to get the data by particular id
		 */
		User userObject = this.userRepo.findById(userId).
		orElseThrow(()->new ResourceNotFoundException("User" , "id",userId));    
		/*
		 * updating the details by using the userObject
		 */
		userObject.setName(userDto.getName());
		userObject.setAbout(userDto.getAbout());
		userObject.setEmail(userDto.getEmail());
		userObject.setPassword(userDto.getPassword());
		
		//saving the changed user details
		User updatedUser = this.userRepo.save(userObject);
		
		// converting the data to userDto so that we can send to client
		UserDto userToDto = this.userToDto(updatedUser);
		return userToDto;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		User userObject = this.userRepo.findById(userId).
				orElseThrow(()->new ResourceNotFoundException("User" , "id",userId)); 
		
		return this.userToDto(userObject);
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> all_users = this.userRepo.findAll();
		/*
		 * converting the user data to userDto data by following
		 */
		List<UserDto> collect_users = all_users.stream().map(user-> this.userToDto(user)).collect(Collectors.toList());       
		return collect_users;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		User userfordelete = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","id",userId));
		this.userRepo.delete(userfordelete);
		
	}
	/*create a method to convert the UserDto class to User class
	 * 
	 */
	private User dtoTOUser(UserDto userDto) {
		User user  = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		System.out.println("password at dtoToUser method user.getEmail() :"+user.getPassword());
		System.out.println("password at dtoToUser method userDto.getEmail() :"+userDto.getPassword());
		return user;
		
	}
	/*create a method to convert the user class to UserDto class
	 * 
	 */
	public UserDto userToDto(User user) {
		
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setAbout(user.getAbout());
		userDto.setEmail(user.getEmail());
		userDto.setName(user.getName());
		userDto.setPassword(user.getPassword());
		
		return userDto;
	}

}
