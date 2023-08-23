package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="application")
@Getter
@ToString
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class Application {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long applicationId;
	
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private JobStatus status;
	
	@ManyToOne
	@JoinColumn(name = "jobId" , nullable = false)
	private Job assignedJobId;
	
	@ManyToOne
	@JoinColumn(name = "jsId" , nullable = false)
	private JobSeeker assignedJsId;
	
	
	

}
