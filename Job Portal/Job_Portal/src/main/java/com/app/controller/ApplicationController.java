package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApplicationSubmitdto;
import com.app.service.ApplicationService;

@RestController
@RequestMapping("/application")
public class ApplicationController {
	
	public ApplicationController() {
		System.out.println("Application Controller Started");
	}
	
	@Autowired
	private ApplicationService applService;
	
	@PostMapping
	public ResponseEntity<?> jobApplication(@RequestBody ApplicationSubmitdto dto)
	{
		
		return ResponseEntity.status(HttpStatus.CREATED).body(applService.insertApplication(dto));
	}
}
