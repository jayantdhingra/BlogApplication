package com.blog.services;

import java.util.List;

import com.blog.entities.Post;
import com.blog.payloads.PostDto;

public interface PostService {
	
	//create
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	// update
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	
	void deletePost(Integer postId);
	
	//get all posts
	
	List<PostDto> getAllPost(Integer pageNumber, Integer pageSize);
	
	//get single post
	
	PostDto getPostById(Integer postId);
	
	// get all posts by category
	List<PostDto> getPostsByCategory(Integer categoryId); 
	
	// get all posts by User
	
	List<PostDto> getPostsByUser(Integer userId);
	
	//search post
	List<PostDto> searchPosts(String keyword); 

}
