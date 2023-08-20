package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.customexception.ResourceNotFoundException;
import com.app.dto.InsertJobseekerDto;
import com.app.dto.Signindto;
import com.app.entity.JobSeeker;
import com.app.service.JobSeekerService;

@RestController
@RequestMapping("/jobseeker")
public class JobSeekerController {
	
	public JobSeekerController() {
		System.out.println("Job seeker controller started");
	}
	
	@Autowired
	private JobSeekerService jobSeekerService;
	
	@PostMapping("/registration")
	public ResponseEntity<?> insertJobSeeker(@RequestBody InsertJobseekerDto dto)
	{
		String result=jobSeekerService.insertJobSeeker(dto);
		
		return ResponseEntity.status(HttpStatus.OK).body(result);	
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> JSSignin(@RequestBody Signindto dto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(jobSeekerService.signIn(dto));
	}
	
	@GetMapping("/seekerlist")
	public List<JobSeeker> listJobSeeker(){
		return jobSeekerService.getAllSeekerList();
	}
	
	@GetMapping("/{jsid}")
	public JobSeeker getById(@PathVariable long jsid)
	{
		return jobSeekerService.getJobSeekerById(jsid); 
	}
	

}
