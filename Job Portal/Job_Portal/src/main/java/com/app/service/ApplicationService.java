package com.app.service;

import java.util.List;

import com.app.entity.Application;

public interface ApplicationService {
	
	//String insertApplication(ApplicationSubmitdto dto);
	String insertApplication(String userName, long jobId);
	
	List<Application> listApplicationsByJob(Long jobId);

}
