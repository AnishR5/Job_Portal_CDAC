package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.AdminRegisterDto;
import com.app.dto.Signindto;
import com.app.entity.Admin;
import com.app.repository.AdminRepo;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	public AdminServiceImpl() {
		System.out.println("AdminService started");
	}
	
	@Autowired
	private AdminRepo adminRepo;
	@Autowired
	private ModelMapper mapper;

	@Override
	public String insertAdmin(AdminRegisterDto admindto) {
		try {
			Admin admin=mapper.map(admindto, Admin.class);
			adminRepo.save(admin);
		}catch (Exception e) {
			return "Failed";
		}
		return "Success";
	}

	@Override
	public Admin signIn(Signindto dto) {
		try {
			Admin admin=adminRepo.findByAdminUserNameAndAdminPassword(dto.getUserName(), dto.getPassword()).get();
			return admin;
		}catch (Exception e) {
			return null;
		}
		
		
	}
	
}
