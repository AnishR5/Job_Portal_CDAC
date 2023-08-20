package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.JobCategory;
import com.app.repository.JobCategoryRepo;

@Service
@Transactional
public class JobCategoryServiceImpl implements JobCategoryService {

	@Autowired
	private JobCategoryRepo jobCategoryRepo;
	
	@Override
	public String insertJobCategoryDetails(JobCategory jobCategory) {
		
		try{
			jobCategoryRepo.save(jobCategory);
		}catch(Exception e) {
			e.printStackTrace();
			return "Failed";
		}
		return "Success";
	}

}
