package com.app.service;



import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customexception.ResourceNotFoundException;
import com.app.dto.InsertJobseekerDto;
import com.app.dto.ListAllJobSeekerDto;
import com.app.dto.Signindto;
import com.app.entity.JobSeeker;
import com.app.repository.JobSeekerRepo;

@Service
@Transactional
public class JobSeekerServiceImpl implements JobSeekerService {
	
	public JobSeekerServiceImpl() {
		System.out.println("JobSeeker Service Started");
	}
	@Autowired
	private JobSeekerRepo jsRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public String insertJobSeeker(InsertJobseekerDto dto) {
		//InsertJobseekerDto dto1=new InsertJobseekerDto("abc", "ssd", "rt", "ani@gmmail.com", "werty", "234567", Gender.MALE, "wert", "sfrdt", "iji", "uihi", 2);
		System.out.println(dto);
		
		JobSeeker js=mapper.map(dto, JobSeeker.class);
	
		try {
			System.out.println(js);
			jsRepo.save(js);
			
		} catch (Exception e) {
			return "Fail";
		}				
		return "Success";
	}

	@Override
	public List<JobSeeker> getAllSeekerList() {

		return jsRepo.findAll();
	}

	@Override
	public  JobSeeker getJobSeekerById(long jsid) {
		
		return jsRepo.findById(jsid).orElseThrow(()->new ResourceNotFoundException("Id not found"));
	}

	@Override
	public String signIn(Signindto dto) {
		try {
			jsRepo.findByUserNameAndPassword(dto.getUserName(), dto.getPassword()).orElseThrow(()->new ResourceNotFoundException("Invalid credetials"));
		}catch (Exception e) {
			return "Login failed";
		}
		return "Login Success";
	}

	
	
}
