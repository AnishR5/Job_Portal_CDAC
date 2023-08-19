package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.JPRegisterdto;
import com.app.service.JobProviderService;

@RestController
@RequestMapping("/jobprovider")
public class JobProviderController {
	
	public JobProviderController() {
		System.out.println("JobProviderController started");
	}
	
	@Autowired
	private JobProviderService jpService;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerJP(@RequestBody JPRegisterdto dto)
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(jpService.registerJP(dto));
	}

}
