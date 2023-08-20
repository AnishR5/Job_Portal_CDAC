package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.JobCategory;
import com.app.service.JobCategoryService;

@RestController
@RequestMapping("/jobcategory")
public class JobCategoryController {

	@Autowired
	private JobCategoryService jobCategoryService;
	
	@PostMapping("/insertjc")
	public ResponseEntity<?> insertJobCategory(@RequestBody JobCategory jobCategory)
	{
		String result = jobCategoryService.insertJobCategoryDetails(jobCategory);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
}
