package com.blogapp.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.apis.entities.User;

// here we define that we are using the user entity which has integer types id.
/*
 * it implements all the predefine methods of JPA which helps to performs database
 * operation without writing the SQL queries.
 */
public interface UserRepo extends JpaRepository<User , Integer> {

}
