package com.blogapp.apis.payloads;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	
	private int category_id;
	
	@NotEmpty(message="plz enter a title for category")
	private String category_title;
	
	@NotEmpty(message="plz enter a description for category")
	private String category_description;

}
