package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.app.dto.InsertJobseekerDto;
import com.app.dto.JSInfo;
import com.app.dto.JSUpdateDto;
import com.app.dto.Signindto;
import com.app.entity.JobSeeker;
import com.app.service.JobSeekerService;

@RestController
@RequestMapping("/jobseeker")
@SessionAttributes("jobseeker")
@CrossOrigin(origins = "http://localhost:3000")
public class JobSeekerController {
	
	public JobSeekerController() {
		System.out.println("Job seeker controller started");
	}
	
	@Autowired
	private JobSeekerService jobSeekerService;
	
	@PostMapping("/registration")
	public ResponseEntity<?> insertJobSeeker(@RequestPart InsertJobseekerDto dto,@RequestPart(required = false) MultipartFile resume,MultipartHttpServletRequest request )
	{
		String result=jobSeekerService.insertJobSeeker(dto,resume,request);
		
		return ResponseEntity.status(HttpStatus.OK).body(result);	
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> JSSignin(@RequestBody Signindto dto,HttpServletRequest request)
	{
		boolean res=jobSeekerService.signIn(dto,request);
		return ResponseEntity.status(HttpStatus.OK).body(res);
	}
	

	
	@GetMapping("/seekerlist")
	public List<JobSeeker> listJobSeeker(){
		return jobSeekerService.getAllSeekerList();
	}
	
	@GetMapping("/{jsId}")
	public JobSeeker getById(@PathVariable long jsId)
	{
		return jobSeekerService.getJobSeekerById(jsId); 
	}
	
	@DeleteMapping("/{jsId}")
	public String deleteById(@PathVariable long jsId)
	{
		return jobSeekerService.deleteJsById(jsId);
	}
	
	@GetMapping("/profile")
	public JSInfo profile(HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		JSInfo info=new JSInfo();
		info.setJsId((Long)session.getAttribute("jsID"));
		info.setUserName((String)session.getAttribute("jsName"));
		return info;		
	}
	
	@GetMapping("/signout")
	public void SignOut(HttpServletRequest request)
	{
		request.getSession().invalidate();
	}
	
	@PutMapping("/{jsId}")
	public String updateJS(@PathVariable long jsId,@RequestBody JSUpdateDto updateDto)
	{
		String result = jobSeekerService.updateJSById(jsId,updateDto);
		return result;
	}
}
