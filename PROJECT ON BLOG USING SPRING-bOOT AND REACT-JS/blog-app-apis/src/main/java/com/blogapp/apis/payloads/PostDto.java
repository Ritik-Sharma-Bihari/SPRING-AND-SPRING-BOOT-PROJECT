package com.blogapp.apis.payloads;

import java.util.Date;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
	
	private int post_id;

	@NotEmpty(message="plz enter a title for post")
	private String post_title;
	
	@NotEmpty(message="plz fill the post content")
	@Size(min=5,max=1000,message=" content must be between 5 to 1000!!")
	private String post_content;
	
	@NotEmpty(message="plz fill the image section")
	private String post_images = "default.png" ;
	
	private Date addedDate;
	/*
	 * to handle the mapping
	 */
	private UserDto user;
	private CategoryDto category;

}
