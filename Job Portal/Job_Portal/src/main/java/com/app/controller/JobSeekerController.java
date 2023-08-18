package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.InsertJobseekerDto;
import com.app.service.JobSeekerService;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/jobseeker")
public class JobSeekerController {
	
	public JobSeekerController() {
		System.out.println("Job seeker controller started");
	}
	
	@Autowired
	private JobSeekerService jobSeekerService;
	
	@PostMapping("/insert")
	public ResponseEntity<?> insertJobSeeker(@RequestBody InsertJobseekerDto dto)
	{
		String result=jobSeekerService.insertJobSeeker(dto);
		return ResponseEntity.status(HttpStatus.OK).body(result);	
	}
	
	

}
