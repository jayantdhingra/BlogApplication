package com.blog.controllers;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.ApiResponse;
import com.blog.payloads.CategoryDto;
import com.blog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	
	// CREATING CATEGORY -- POST
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		
		CategoryDto createCat =this.categoryService.createCategory(categoryDto);
		
		return new ResponseEntity<CategoryDto>(createCat, HttpStatus.CREATED);	
	}
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId){
		
		CategoryDto updatedCat = this.categoryService.updateCategory(categoryDto, categoryId);
		
		return new ResponseEntity<CategoryDto>(updatedCat, HttpStatus.OK);
	}
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
		
		this.categoryService.deleteCategory(categoryId);
		
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category has been deleted successfully", true), HttpStatus.OK );
	
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
		
		return new ResponseEntity<CategoryDto>(this.categoryService.getCategory(categoryId), HttpStatus.OK);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories(){
		
//		List<CategoryDto> category = this.categoryService.getCategories();
	
		return ResponseEntity.ok(this.categoryService.getCategories());

	}
	
	
}
