package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public String insertAdmin(Admin admin) {
		try {
			adminRepo.save(admin);
		}catch (Exception e) {
			return "Failed";
		}
		return "Success";
	}
	
}
