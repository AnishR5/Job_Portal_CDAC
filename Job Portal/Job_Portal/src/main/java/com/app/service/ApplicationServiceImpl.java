package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApplicationSubmitdto;
import com.app.entity.Application;
import com.app.repository.ApplicationRepo;

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

	@Override
	public String insertApplication(ApplicationSubmitdto dto) {
		Application appl=mapper.map(dto, Application.class);
		try {
			applRepo.save(appl);
		}catch (Exception e) {
			return "Failed";
		}
		return "Success";
	}
}
