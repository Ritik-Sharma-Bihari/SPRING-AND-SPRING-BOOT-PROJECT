package com.blogapp.apis.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.blogapp.apis.model.User;

@Service
public class UserResvice {

	private List<User> store = new ArrayList<>();

	
	public UserResvice() {
		store.add(new User(UUID.randomUUID().toString(), "ritik shrma", "ritk@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(), "ankit shrma", "ritk@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(), "pk shrma", "ritk@gmail.com"));
		store.add(new User(UUID.randomUUID().toString(), "godu shrma", "ritk@gmail.com"));
	}

	public List<User> getUsers() {
		return this.store;
	}
}
