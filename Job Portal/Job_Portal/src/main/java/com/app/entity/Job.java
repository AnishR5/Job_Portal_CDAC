package com.app.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Setter
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long jobId;
	@ManyToOne
	@JoinColumn(name = "jpId", nullable = false)
	private JobProvider jpId;
	@ManyToOne
	@JoinColumn(name = "jcId", nullable = false)
	private JobCategory jcId;
	@ManyToOne
	@JoinColumn(name = "locationId", nullable = false)
	private Location locationId;
	@Column(length = 50)
	private String jobTitle;
	@Column(length = 50)
	private String role;
	@Column(length = 50,nullable = false)
	private String keySkills;
	@Column(nullable = false)
	private double salary;
	private String description;
	@Column(nullable = false)
	private int vacancies;
	@Column(nullable = false)
	private LocalDate applicationDeadline;
	@OneToMany(mappedBy = "jobId",cascade = CascadeType.ALL,orphanRemoval = true)
	private Map<Long,Application> applicationList=new HashMap<Long, Application>();

}
