package com.app.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customexception.ResourceNotFoundException;
import com.app.dto.InsertJobseekerDto;
import com.app.dto.JSUpdateDto;
import com.app.dto.Signindto;
import com.app.entity.JobSeeker;
import com.app.repository.JobSeekerRepo;

@Service
@Transactional
public class JobSeekerServiceImpl implements JobSeekerService {

	public JobSeekerServiceImpl() {
		System.out.println("JobSeeker Service Started");
	}

	@Autowired
	private JobSeekerRepo jsRepo;

	@Autowired
	private ModelMapper mapper;

//	@Override
//	public String insertJobSeeker(InsertJobseekerDto dto,MultipartFile resume,MultipartHttpServletRequest request) {
//		
//		System.out.println(dto);
//
//		JobSeeker js = mapper.map(dto, JobSeeker.class);
//
//		try {
//			System.out.println(js);
//			jsRepo.save(js);
//			 if (resume != null && !resume.isEmpty()) {
//				 Blob resumeBlob = new SerialBlob(resume.getBytes());
//
//		            // Set the resume field as a Blob in the entity
//		            js.setResume(resumeBlob);
//		            
//		        }
//			 jsRepo.save(js); // Update the entity to associate the resume
//
//		} catch (Exception e) {
//			return "Fail";
//		}
//		return "Success";
//	}
	
	

	@Override
	public String insertJobSeeker(InsertJobseekerDto dto) {
		System.out.println(dto);
		JobSeeker js = mapper.map(dto, JobSeeker.class);
		try {
			System.out.println(js);
			jsRepo.save(js);
		} catch (Exception e) {
			return "Fail";
		}
		return "Success";
	}

	@Override
	public List<JobSeeker> getAllSeekerList() {

		return jsRepo.findAll();
	}

	@Override
	public JobSeeker getJobSeekerById(long jsid) {

		return jsRepo.findById(jsid).orElseThrow(() -> new ResourceNotFoundException("Id not found"));
	}
	
	@Override
	public JobSeeker getJobSeekerByUserName(String userName) {

		return jsRepo.findByUserName(userName).orElseThrow(() -> new ResourceNotFoundException("Id not found"));
	}

	@Override
	public String deleteJsById(long jsId) {
		String msg = "Job Seeker Id does not exist";
		if (jsRepo.existsById(jsId)) {
			jsRepo.deleteById(jsId);
			msg = "Job Seeker deleted";
		}
		return msg;
	}

	@Override
//	public boolean signIn(Signindto dto, HttpServletRequest request) {
//		try {
//			JobSeeker js = jsRepo.findByUserNameAndPassword(dto.getUserName(), dto.getPassword())
//					.orElseThrow(() -> new ResourceNotFoundException("Invalid credetials"));
//			// System.out.println(js);
//			HttpSession session = request.getSession();
//
//			session.setAttribute("jsID", js.getJsId());
//			session.setAttribute("jsName", js.getUserName());
//		} catch (Exception e) {
//			return false;

	public JobSeeker signIn(Signindto dto) {
		try {
			JobSeeker js=jsRepo.findByUserNameAndPassword(dto.getUserName(), dto.getPassword()).orElseThrow(()->new ResourceNotFoundException("Invalid credetials"));
			//System.out.println(js);
			return js;
		}catch (Exception e) {
			return null;

		}
		
	}

	@Override
	public String updateJSByUserName(String userName, JSUpdateDto updateDto) {
		Optional<JobSeeker> existingId = jsRepo.findByUserName(userName);
		if (existingId.isPresent()) {
			JobSeeker existingJobSeeker = existingId.get();
			existingJobSeeker.setJsFullName(updateDto.getJsFullName());
			existingJobSeeker.setEmail(updateDto.getEmail());
			existingJobSeeker.setAddress(updateDto.getAddress());
			existingJobSeeker.setPhoneNo(updateDto.getPhoneNo());
			existingJobSeeker.setGender(updateDto.getGender());
			existingJobSeeker.setEducation(updateDto.getEducation());
			existingJobSeeker.setSkill1(updateDto.getSkill1());
			existingJobSeeker.setSkill2(updateDto.getSkill2());
			existingJobSeeker.setSkill3(updateDto.getSkill3());
			existingJobSeeker.setExperience(updateDto.getExperience());
			jsRepo.save(existingJobSeeker);
			return "Updated Successfully";
		} else {
			return "Id Does Not Exist";
		}

	}
}
