package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.customexception.ResourceNotFoundException;
import com.app.dto.InsertJobseekerDto;
import com.app.entity.JobSeeker;

public interface JobSeekerService {
	
	String insertJobSeeker(InsertJobseekerDto dto);

	List<JobSeeker> getAllSeekerList();

	JobSeeker getJobSeekerById(long jsid);

	String deleteJsById(long jsId);


}
