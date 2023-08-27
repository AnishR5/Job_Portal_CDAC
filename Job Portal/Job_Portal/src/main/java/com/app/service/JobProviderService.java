package com.app.service;

import java.util.List;

import com.app.dto.JPRegisterdto;
import com.app.dto.JPUpdateDto;
import com.app.dto.Signindto;
import com.app.entity.JobProvider;

public interface JobProviderService {
	
	String registerJP(JPRegisterdto dto);
	
	List<JobProvider> getAllJP();
	
	JobProvider getJPbyID(Long jpid);
	
	JobProvider signIn(Signindto dto);

	String updateJPDetails(String userName, JPUpdateDto jpUpdateDto);

	JobProvider getJPbyUserName(String userName);

}
