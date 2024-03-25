package com.blogapp.apis.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.blogapp.apis.entities.*;

public interface PostRepo extends JpaRepository<Post , Integer> {

	/*
	 * creating JPA costume method 
	 */
	List<Post>findByUser(User user);
	List<Post>findByCategory(Category category);
}

