package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Setter
public class Application {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long applicationId;
	@ManyToOne
	@JoinColumn(name = "jobId" , nullable = false)
	private Job jobId;
	@ManyToOne
	@JoinColumn(name = "jsId" , nullable = false)
	private JobSeeker jsId;
	@Column(length = 20)
	private String status;
	

}
