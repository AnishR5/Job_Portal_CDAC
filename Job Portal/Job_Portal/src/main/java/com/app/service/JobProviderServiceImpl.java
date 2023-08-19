package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.JPRegisterdto;
import com.app.entity.JobProvider;
import com.app.repository.JobProviderRepo;

@Service
@Transactional
public class JobProviderServiceImpl implements JobProviderService {
	
	public JobProviderServiceImpl() {
		System.out.println("JobProviderService Started");
	}
	
	@Autowired
	private JobProviderRepo jpRepo;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public String registerJP(JPRegisterdto dto) {
		JobProvider jp=mapper.map(dto, JobProvider.class);
		try
		{
			jpRepo.save(jp);
		}catch (Exception e) {
			return "Failed";
		}
		return "Success";
	}
	

}
