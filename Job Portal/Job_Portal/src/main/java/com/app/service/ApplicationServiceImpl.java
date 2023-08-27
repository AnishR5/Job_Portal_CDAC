package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApplicationSubmitdto;
import com.app.entity.Application;
import com.app.entity.Job;
import com.app.entity.JobSeeker;
import com.app.entity.JobStatus;
import com.app.repository.ApplicationRepo;
import com.app.repository.JobRepo;
import com.app.repository.JobSeekerRepo;

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
	@Autowired
	private JobSeekerService jsService;
	@Autowired
	private JobSeekerRepo jobSeekerRepo;

	/*
	 * @Override public String insertApplication(ApplicationSubmitdto dto) {
	 * 
	 * try { System.out.println(dto); Application appl=mapper.map(dto,
	 * Application.class); System.out.println(appl); JobSeeker
	 * js=jsService.getJobSeekerById(dto.getJsId()); System.out.println(js); Job
	 * job=jobRepo.findById(dto.getJobId()).get(); System.out.println(job);
	 * appl.setAssignedJobId(job); appl.setAssignedJsId(js);
	 * System.out.println(appl); js.addApplication(appl); job.addApplication(appl);
	 * applRepo.save(appl); }catch (Exception e) { return "Failed"; } return
	 * "Success"; }
	 */
	
	@Override
	public String insertApplication(ApplicationSubmitdto dto, long jobId) {
		
		try {
			System.out.println(dto);
			Application appl=mapper.map(dto, Application.class);
			System.out.println(appl);
			//JobSeeker js=jsService.getJobSeekerById(1);	
			JobSeeker js=jobSeekerRepo.findByUserName(dto.getUserName()).get();
			System.out.println(js);
			Job job=jobRepo.findById(jobId).get();		
			System.out.println(job);
			appl.setAssignedJobId(job);
			appl.setAssignedJsId(js);
			appl.setStatus(JobStatus.APPLIED);
			System.out.println(appl);
			applRepo.save(appl);
		}catch (Exception e) {
			return "Failed";
		}
		return "Success";
	}
}
