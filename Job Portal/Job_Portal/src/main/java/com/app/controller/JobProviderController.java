package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.JPRegisterdto;
import com.app.dto.Signindto;
import com.app.entity.JobProvider;
import com.app.service.JobProviderService;

@RestController
@RequestMapping("/jobprovider")
//@CrossOrigin(origins = "http://localhost:3000")
public class JobProviderController {
	
	public JobProviderController() {
		System.out.println("JobProviderController started");
	}
	
	@Autowired
	private JobProviderService jpService;
	
	@PostMapping("/registration")
	public ResponseEntity<?> registerJP(@RequestBody JPRegisterdto dto)
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(jpService.registerJP(dto));
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> JpSignin(@RequestBody Signindto dto)
	{
		return ResponseEntity.status(HttpStatus.OK).body(jpService.signIn(dto));
	}
	
	@GetMapping("/providerlist")
	public List<JobProvider> listJobProvider()
	{
		return jpService.getAllJP();
	}
	
	@GetMapping("/{jpid}")
	public JobProvider getById(@PathVariable Long jpid)
	{
		return jpService.getJPbyID(jpid);
	}

}
