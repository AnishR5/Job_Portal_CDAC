package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.Location;
import com.app.repository.LocationRepo;

@Service
@Transactional
public class LocationServiceImpl implements LocationService{

	@Autowired
	private LocationRepo locationRepo;
	
	@Override
	public String insertLocationDetails(Location location) {
		
		try{
			locationRepo.save(location);
		}catch(Exception e) {
			e.printStackTrace();
			return "Failed";
		}
		return "Success";
	}

	
}
