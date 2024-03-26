package com.blogapp.apis.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.blogapp.apis.payloads.ApiREsponse;
import com.blogapp.apis.payloads.PostDto;
import com.blogapp.apis.payloads.PostResponse;
import com.blogapp.apis.services.PostService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	//POST-API
	@PostMapping("/createPost/{userId}/categories/{categoryId}/posts")
	public ResponseEntity<PostDto> creatPost( @Valid @RequestBody PostDto postDto,@PathVariable("userId") int userId,
			@PathVariable("categoryId") int categoryId){
		
		PostDto createPost = this.postService.CreatePost(postDto, userId, categoryId);
		// to send the client SMS
		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED) ;
		
	}
	
	//PUT-API
	@PutMapping("/updatePost/{postid}")
	public ResponseEntity<PostDto> UpdatePost( @Valid @RequestBody PostDto postDto,
			@PathVariable("postid") int postid){
		
		PostDto updatePost = this.postService.UpdatePost(postDto, postid);
		// to send the client SMS
		return new ResponseEntity<>(updatePost, HttpStatus.OK) ;
		
	}
	
	//GET-API (GET A DATA)
	@GetMapping("/post/{postId}")
	public ResponseEntity<PostDto> getPost(@PathVariable Integer postId){
		
		PostDto singlePost = this.postService.getPost(postId);
		
		return new ResponseEntity<PostDto>(singlePost, HttpStatus.OK) ;
		
		
	}
	
	
	//GET-API (GET ALL DATA)
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value="pageNumber",defaultValue="0",required=false) Integer pageNumber,
			@RequestParam(value="pageSize",defaultValue="3",required=false) Integer pageSize,
			@RequestParam(value="sortBy",defaultValue="postId",required=false) String sortBy,
			@RequestParam(value="sortDir",defaultValue="asc",required=false) String sortDir
			){
		
		// List<PostDto> allPost = this.postService.getAllPost(pageNumber,pageSize);
		PostResponse allPost = this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);
		
		return new ResponseEntity<PostResponse>(allPost, HttpStatus.OK) ;
		
		
	}
	
	//DELETE-API (DELETE A DATA)
	@DeleteMapping("/user/posts/{postId}")
	public ApiREsponse DeletePost(@PathVariable Integer postId){
		
		this.postService.DeletePost(postId);
		
		return new ApiREsponse("Post is successfull deleted !!", true);
		
		
	}
	
	//GET-API (GET ALL POST by USER)
	@GetMapping("/user/{userID}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userID){
		
		List<PostDto> postsByUser = this.postService.getPostsByUser(userID);
		
		return new ResponseEntity<List<PostDto>>(postsByUser, HttpStatus.OK) ;
		
		
	}
	
	// get post by category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsBycategory(@PathVariable Integer categoryId){
			
			List<PostDto> postsByCategory = this.postService.getPostsByCategory(categoryId);
			
			return new ResponseEntity<List<PostDto>>(postsByCategory, HttpStatus.OK) ;
			
			
		}
	
	// searching a post by title
	@GetMapping("/search/{keywords}")
	public ResponseEntity<List<PostDto>> serchPostByTitle(
			@PathVariable("keywords") String keywords
			){
		List<PostDto> searchPosts = this.postService.searchPosts(keywords);
		
		return new ResponseEntity<List<PostDto>>(searchPosts,HttpStatus.OK);
	}

}
