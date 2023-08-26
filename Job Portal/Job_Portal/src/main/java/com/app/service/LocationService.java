package com.app.service;

import java.util.List;

import com.app.entity.Location;

public interface LocationService {

	String insertLocationDetails(Location location);

	List<Location> allLocation();

	
}
