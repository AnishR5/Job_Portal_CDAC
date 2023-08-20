package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.JobDto;
import com.app.service.JobService;

@RestController
@RequestMapping("/job")
public class JobController {

	
	@Autowired
	private JobService jobService;
	
	@PostMapping("/insertjob")
	public ResponseEntity<?> insertJobDetails(@RequestBody JobDto dto)
	{
		String jobResult = jobService.insertJob(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(jobResult);
	}
}
