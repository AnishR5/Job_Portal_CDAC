package com.app.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customexception.ResourceNotFoundException;
import com.app.dto.JPRegisterdto;
import com.app.dto.JPUpdateDto;
import com.app.dto.Signindto;
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

	@Override
	public List<JobProvider> getAllJP() {
		
		return jpRepo.findAll();
	}

	@Override
	public JobProvider getJPbyID(Long jpid) {
		
		return jpRepo.findById(jpid).orElseThrow(()-> new ResourceNotFoundException("Cannot find id"));
	}
	
	@Override
	public JobProvider getJPbyUserName(String userName) {
		
		return jpRepo.findByUserName(userName).orElseThrow(()-> new ResourceNotFoundException("Cannot find userName"));
	}

	@Override
	public JobProvider signIn(Signindto dto) {
		try {
		JobProvider jp=jpRepo.findByUserNameAndPassword(dto.getUserName(), dto.getPassword()).orElseThrow(()->new ResourceNotFoundException("invalid credentials"));
		return jp;
		}catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public String updateJPDetails(String userName, JPUpdateDto jpUpdateDto) {
		Optional<JobProvider> existingName = jpRepo.findByUserName(userName);
		if(existingName.isPresent())
		{
			JobProvider existingJP = existingName.get();
			existingJP.setJpName(jpUpdateDto.getJpName());
			existingJP.setEmail(jpUpdateDto.getEmail());
			existingJP.setAddress(jpUpdateDto.getAddress());
			existingJP.setPhoneNo(jpUpdateDto.getPhoneNo());
			existingJP.setWebSite(jpUpdateDto.getWebSite());
			jpRepo.save(existingJP);
			return "Updated Successfully";
		}else {
			return "Name Does Not Exist";
		}
		
	}

	
	

}
