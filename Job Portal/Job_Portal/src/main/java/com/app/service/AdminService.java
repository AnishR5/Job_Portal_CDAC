package com.app.service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.dto.AdminRegisterDto;
import com.app.dto.Signindto;
import com.app.entity.Admin;

public interface AdminService {
	
	String insertAdmin(AdminRegisterDto admin);
	
	Admin signIn(Signindto dto,HttpServletResponse response,HttpSession session);

}
