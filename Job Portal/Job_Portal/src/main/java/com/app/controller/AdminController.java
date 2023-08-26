package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Admin;
import com.app.service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
	
	public AdminController() {
		System.out.println("Admin Controller Started");
	}
	
	@Autowired
	private AdminService adminService;
	
	
	@PostMapping("/registration")
	public ResponseEntity<?> registerAdmin(@RequestBody Admin admin)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(adminService.insertAdmin(admin));
	}

}
