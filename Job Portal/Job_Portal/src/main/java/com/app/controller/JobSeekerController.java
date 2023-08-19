package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.InsertJobseekerDto;
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
	
	@GetMapping("/seekerlist")
	public List<JobSeeker> listJobSeeker(){
		return jobSeekerService.getAllSeekerList();
	}
	
	

}
