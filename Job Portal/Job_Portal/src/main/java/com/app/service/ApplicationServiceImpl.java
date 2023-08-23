package com.app.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApplicationSubmitdto;
import com.app.entity.Application;
import com.app.entity.Job;
import com.app.entity.JobSeeker;
import com.app.repository.ApplicationRepo;
import com.app.repository.JobRepo;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {
	
	public ApplicationServiceImpl() {
		System.out.println("ApplicationService started");
	}
	
	@Autowired
	private ApplicationRepo applRepo;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private JobRepo jobRepo;
	
	private JobSeekerService jsService;

	@Override
	public String insertApplication(ApplicationSubmitdto dto) {
		System.out.println(dto);
		Application appl=mapper.map(dto, Application.class);
		//System.out.println(appl);
		JobSeeker js=jsService.getJobSeekerById(dto.getJsId());	
		System.out.println(js);
		Job job=jobRepo.findById(dto.getJobId()).get();		
		System.out.println(job);
		appl.setAssignedJobId(job);
		appl.setAssignedJsId(js);
		System.out.println(appl);
		js.addApplication(appl);
		job.addApplication(appl);
		try {
			applRepo.save(appl);
		}catch (Exception e) {
			return "Failed";
		}
		return "Success";
	}
}
