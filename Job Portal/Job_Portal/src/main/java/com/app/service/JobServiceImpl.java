package com.app.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customexception.ResourceNotFoundException;
import com.app.dto.JobDto;
import com.app.entity.Job;
import com.app.entity.JobCategory;
import com.app.entity.JobProvider;
import com.app.entity.Location;
import com.app.repository.JobCategoryRepo;
import com.app.repository.JobProviderRepo;
import com.app.repository.JobRepo;
import com.app.repository.LocationRepo;

@Service
@Transactional
public class JobServiceImpl implements JobService {

	@Autowired
	private JobRepo jobRepo;
	@Autowired
	private JobProviderRepo jobProviderRepo;
	@Autowired
	private LocationRepo locationRepo;
	@Autowired
	private JobCategoryRepo jobCategoryRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public String insertJob(JobDto dto) {
		try {
			Job job = mapper.map(dto, Job.class);
			Optional<JobProvider> jobProvider = jobProviderRepo.findById(dto.getJpId());
			job.setJpId(jobProvider.get());
			Optional<JobCategory> jobCategory = jobCategoryRepo.findById(dto.getJcId());
			job.setJcId(jobCategory.get());
			Optional<Location> location = locationRepo.findById(dto.getLocationId());
			job.setLocationId(location.get());
			jobRepo.save(job);
		} catch (Exception e) {
			e.printStackTrace();
			return "Failed";
		}
		return "Success";
	}

}
