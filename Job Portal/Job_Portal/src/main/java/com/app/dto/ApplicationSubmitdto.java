package com.app.dto;

import com.app.entity.JobStatus;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ApplicationSubmitdto {
	
	private Long jobId;
	private Long jsId;
	private JobStatus status;

}
