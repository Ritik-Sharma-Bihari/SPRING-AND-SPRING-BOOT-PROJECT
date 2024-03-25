package com.blogapp.apis.entities;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="posts")
@NoArgsConstructor
@Getter
@Setter
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int post_id;
	
	private String post_title;
	
	@Column(length=1000)
	private String post_content;
	
	private String post_images;
	
	private Date addedDate;
	/*
	 * to maintain the mapping between user , post and category we are writing
	 * below code.
	 */
	@ManyToOne
	@JoinColumn(name="category_join_id")
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="user_join_id")
	private User user;

}
