package com.app.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.AdminRegisterDto;
import com.app.dto.Signindto;
import com.app.entity.Admin;
import com.app.entity.JobSeeker;
import com.app.repository.AdminRepo;
import com.app.util.JwtUtil;
import com.app.util.SaveCookie;

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
	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public String insertAdmin(AdminRegisterDto admindto) {
		try {
			BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
			Admin admin=mapper.map(admindto, Admin.class);
			String encryptedPassword=bcrypt.encode(admin.getAdminPassword());
			admin.setAdminPassword(encryptedPassword);
			adminRepo.save(admin);
		}catch (Exception e) {
			return "Failed";
		}
		return "Success";
	}

	@Override
	public Admin signIn(Signindto dto,HttpServletResponse response,HttpSession session) {
		
		try {
			BCryptPasswordEncoder bcrypt=new BCryptPasswordEncoder();
			
			Admin admin=adminRepo.findByAdminUserNameAndAdminPassword(dto.getUserName(), dto.getPassword()).get();
			if(bcrypt.matches(dto.getPassword(), admin.getAdminPassword()))
			{
				final String jwt=jwtUtil.generateToken(admin.getAdminUserName());
				session.setAttribute("admin", admin);
				SaveCookie.sendToken(jwt, response);
			}
			return admin;
		}catch (Exception e) {
			return null;
		}
		
		
	}
	
}
