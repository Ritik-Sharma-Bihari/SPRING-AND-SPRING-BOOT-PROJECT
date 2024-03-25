package com.blogapp.apis.services.imps;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.blogapp.apis.entities.Category;
import com.blogapp.apis.entities.Post;
import com.blogapp.apis.entities.User;
import com.blogapp.apis.exceptions.ResourceNotFoundException;
import com.blogapp.apis.payloads.PostDto;
import com.blogapp.apis.repositories.*;
import com.blogapp.apis.repositories.UserRepo;
import com.blogapp.apis.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	/*
	 * overriding the PostDto CreatePost() to create a Post
	 */
	@Override
	public PostDto CreatePost(PostDto postDto, Integer userId, Integer categoryId) {
		// TODO Auto-generated method stub
		User userObject = this.userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User" , "id",userId));
		
		Category categoryObject = this.categoryRepo.findById(categoryId).
				orElseThrow(()->new ResourceNotFoundException("Category" , "Category Id",categoryId));
		
		Post post_mapped = this.modelMapper.map(postDto, Post.class);
		
		post_mapped.setPost_images("default.png");
		post_mapped.setAddedDate(new Date());
		post_mapped.setUser(userObject);
		post_mapped.setCategory(categoryObject);
		
		/*
		 * saving the post to database.
		 */
		Post savedPost = this.postRepo.save(post_mapped);
		
		return this.modelMapper.map(savedPost, PostDto.class);
	}
	
	/*
	 * overriding the PostDto UpdatePost() to Update a Post
	 */
	
	@Override
	public PostDto UpdatePost(PostDto postDto, Integer post_id) {
		// TODO Auto-generated method stub
		
		/*
		 * finding the old data to convert it new data 
		 */
		Post oldPostData = this.postRepo.findById(post_id).
		orElseThrow(()->new ResourceNotFoundException("Post" , "Post Id",post_id));
		/*
		 * setting new data
		 */
		oldPostData.setPost_images(postDto.getPost_images());
		oldPostData.setPost_title(postDto.getPost_title());
		oldPostData.setPost_content(postDto.getPost_content());
		/*
		 * saving the updated data to database
		 */
		Post updatedPost = this.postRepo.save(oldPostData);
		
		return this.modelMapper.map(updatedPost, PostDto.class);
	}
	
	/*
	 * overriding the void DeletePost() to Delete a Post
	 */

	@Override
	public void DeletePost(Integer post_id) {
		// TODO Auto-generated method stub
		Post postTODelete = this.postRepo.findById(post_id).orElseThrow(()-> new ResourceNotFoundException("Post" , "Post Id",post_id));    
		this.postRepo.delete(postTODelete);

	}
	
	/*
	 * overriding the PostDto getPost() to get a Post
	 */

	@Override
	public PostDto getPost(Integer post_id) {
		// TODO Auto-generated method stub
		
		Post postdata = this.postRepo.findById(post_id).
				orElseThrow(()->new ResourceNotFoundException("Post" , "Post Id",post_id));
				
		return this.modelMapper.map(postdata, PostDto.class);
	}
	
	/*
	 * overriding the List<PostDto> getAllPost() to get all Post
	 */

	@Override
	public List<PostDto> getAllPost(Integer pageNumber, Integer pageSize) {	
		
		/*
		 * 		In your 'PostServiceImpl' class, you are creating a 'Pageable' object 'p' and passing it to the
				`findA11() ' method of your 'PostRepo' with 'pageNumber' and 'pageSize'. However, the
				'pageNumber' in 'PageRequest' is zero-based, meaning the first page is '0', not '1'. Therefore,
				when you pass 'pageNumber = 1', it will actually retrieve the second page.
				
				To fix this issue and retrieve the first page when `pageNumber = 1', you need to subtract '1' from
				the 'pageNumber' when creating the 'PageRequest'. Here's how you can fix it:
		 */
		int adjustedPageNumber = pageNumber - 1;
	    
		/* creating object of Pageable interface
		 * Pageable -> Abstract interface for pagination information.
		 * PageRequest-> Basic Java Bean implementation of Pageable.
		 */
	    Pageable pageable = PageRequest.of(adjustedPageNumber, pageSize);
	    
		// to get the all pages post
		Page<Post> pageofPost = this.postRepo.findAll(pageable);
		
		// to get all post
		List<Post> Allcontent = pageofPost.getContent();
		
		//List<Post> allPost = this.postRepo.findAll();
		/*
		 * converting the Post object data to PostDto object data by following
		 */
		List<PostDto> CategoryDtos = Allcontent.stream().map((posts)->this.modelMapper.map(posts, PostDto.class))
				.collect(Collectors.toList());
		return CategoryDtos;
	}
	
	/*
	 * overriding the List<PostDto> getPostsByCategory() to get all Post by particular category id
	 */

	@Override
	public List<PostDto> getPostsByCategory(Integer category_id) {
		// TODO Auto-generated method stub
		Category categoryObject = this.categoryRepo.findById(category_id).
				orElseThrow(()->new ResourceNotFoundException("Category" , "Category Id",category_id));
		/*
		 * to get the all the post by particular category
		 */
		List<Post> allPostByCategory = this.postRepo.findByCategory(categoryObject);
		/*
		 * converting the post to postDto
		 */
		List<PostDto> listOfPostDtos = allPostByCategory.stream().map((categoryposts)->this.modelMapper.
				map(categoryposts, PostDto.class)).collect(Collectors.toList());        
		
		return listOfPostDtos;
	}
	
	/*
	 * overriding the List<PostDto> getPostsByUser() to get all Post by particular user id
	 */

	@Override
	public List<PostDto> getPostsByUser(Integer user_id) {
		// TODO Auto-generated method stub
		
		User userObject = this.userRepo.findById(user_id).
				orElseThrow(()->new ResourceNotFoundException("User" , "id",user_id));
		/*
		 * to get the all the post by particular user
		 */
		List<Post> allPostByUser = this.postRepo.findByUser(userObject);
		/*
		 * converting the post to postDto
		 */
		List<PostDto> listOfPostdtoByUser = allPostByUser.stream().map((userposts)->this.modelMapper.
				map(userposts, PostDto.class)).collect(Collectors.toList());        
		return listOfPostdtoByUser;
	}
	
	/*
	 * overriding the List<PostDto> searchPosts() to search a particular post
	 */


	@Override
	public List<PostDto> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}