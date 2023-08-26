package com.app.controller;

import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.InsertJobseekerDto;
import com.app.dto.Signindto;
import com.app.entity.JobSeeker;
import com.app.service.JobSeekerService;

@RestController
@RequestMapping("/jobseeker")
@CrossOrigin(origins = "http://localhost:3000")
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
	public ResponseEntity<?> JSSignin(@RequestBody Signindto dto,HttpSession session,HttpServletRequest request)
	{
		boolean res=jobSeekerService.signIn(dto,session,request);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
	

	
	@GetMapping("/seekerlist")
	public List<JobSeeker> listJobSeeker(){
		return jobSeekerService.getAllSeekerList();
	}
	
	@GetMapping("/{jsId}")
	public JobSeeker getById(@PathVariable long jsId)
	{
		return jobSeekerService.getJobSeekerById(jsId); 
	}
	
	@DeleteMapping("/{jsId}")
	public String deleteById(@PathVariable long jsId)
	{
		return jobSeekerService.deleteJsById(jsId);
	}
}
