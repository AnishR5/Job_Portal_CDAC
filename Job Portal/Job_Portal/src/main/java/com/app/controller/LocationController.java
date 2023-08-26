package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Location;
import com.app.service.LocationService;

@RestController
@RequestMapping("/location")
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	@PostMapping
	public ResponseEntity<?> saveLocationDetails(@RequestBody Location location)
	{
		String result = locationService.insertLocationDetails(location);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
}