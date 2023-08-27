package com.app.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.app.dto.InsertJobseekerDto;
import com.app.dto.Signindto;
import com.app.entity.JobSeeker;

public interface JobSeekerService {
	
	String insertJobSeeker(InsertJobseekerDto dto,MultipartFile resume,MultipartHttpServletRequest request);

	List<JobSeeker> getAllSeekerList();

	JobSeeker getJobSeekerById(long jsid);
	
	JobSeeker signIn(Signindto dto);

	String deleteJsById(long jsId);


}
