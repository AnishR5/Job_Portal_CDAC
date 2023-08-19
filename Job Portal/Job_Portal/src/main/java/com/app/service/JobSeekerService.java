package com.app.service;

import java.util.List;

import com.app.dto.InsertJobseekerDto;
import com.app.entity.JobSeeker;

public interface JobSeekerService {
	
	String insertJobSeeker(InsertJobseekerDto dto);

	List<JobSeeker> getAllSeekerList();
	

}
