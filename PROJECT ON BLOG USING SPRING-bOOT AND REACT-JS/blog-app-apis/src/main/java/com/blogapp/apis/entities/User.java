package com.blogapp.apis.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String password;
	private String about;
	
	/*
	 * to maintain the mapping between post, user and category
	 */
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Post> posts = new ArrayList<Post>();
	
	/*
	 * joining between many comments for a single user
	 */
	@OneToMany(mappedBy="user",cascade= CascadeType.ALL)
	private Set<Comment> comments = new HashSet<>();

}
