package com.app.service;

import com.app.dto.ApplicationSubmitdto;

public interface ApplicationService {
	
	//String insertApplication(ApplicationSubmitdto dto);
	String insertApplication(ApplicationSubmitdto dto, long jobId);

}
