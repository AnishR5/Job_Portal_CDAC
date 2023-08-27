package com.app.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.app.dto.InsertJobseekerDto;
import com.app.dto.JSUpdateDto;
import com.app.dto.Signindto;
import com.app.entity.JobSeeker;

public interface JobSeekerService {
	
	String insertJobSeeker(InsertJobseekerDto dto,MultipartFile resume,MultipartHttpServletRequest request);

	List<JobSeeker> getAllSeekerList();

	JobSeeker getJobSeekerById(long jsid);
	
	boolean signIn(Signindto dto, HttpServletRequest request);

	String deleteJsById(long jsId);

	String updateJSById(long jsId, JSUpdateDto updateDto);


}
