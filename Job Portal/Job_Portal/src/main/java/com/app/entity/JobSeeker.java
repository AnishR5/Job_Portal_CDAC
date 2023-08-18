package com.app.entity;

import java.sql.Blob;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@ToString
//@NoArgsConstructor
//@AllArgsConstructor
@Setter
@Table(name = "jobseeker")
public class JobSeeker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long jsId;
	private String jsFullName;
	@Column(length = 40, nullable = false,unique = true)
	private String userName;
	@Column(length = 40, nullable = false)
	private String password;
	@Email
	@Column(unique = true, length=100)
	private String email;
	@Column(length = 300, nullable = false)
	private String address;
	@Column(length = 40, nullable = false,unique = true)
	private String phoneNo;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(length=40)
	private String education;
	@Column(length=40)
	private String skill1;
	@Column(length=40)
	private String skill2;
	@Column(length=40)
	private String skill3;
	private int experience;
	private Blob resume;
	@OneToMany(mappedBy = "jsId",cascade = CascadeType.ALL,orphanRemoval = true)
	private Map<Long,Application> applicationList=new HashMap<Long, Application>();
	
	public JobSeeker() {
		System.out.println("in default constructor");
	}
	
	public JobSeeker(String jsFullName, String userName, String password, String email, String address,
			String phoneNo, String gender, String education, String skill1, String skill2, String skill3,
			int experience) {
		super();
		System.out.println("ctr1");
		this.jsFullName = jsFullName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phoneNo = phoneNo;
		this.gender = Gender.valueOf(gender);
		this.education = education;
		this.skill1 = skill1;
		this.skill2 = skill2;
		this.skill3 = skill3;
		this.experience = experience;
	}


	public JobSeeker(Long jsId, String jsFullName, String userName, String password, String email,
			String address, String phoneNo, String gender, String education, String skill1,
			String skill2, String skill3, int experience) {
		super();
		System.out.println("ctr2");
		this.jsId = jsId;
		this.jsFullName = jsFullName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phoneNo = phoneNo;
		this.gender = Gender.valueOf(gender);
		this.education = education;
		this.skill1 = skill1;
		this.skill2 = skill2;
		this.skill3 = skill3;
		this.experience = experience;
	}


	public Long getJsId() {
		return jsId;
	}


	public void setJsId(Long jsId) {
		this.jsId = jsId;
	}


	public String getJsFullName() {
		return jsFullName;
	}


	public void setJsFullName(String jsFullName) {
		this.jsFullName = jsFullName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		gender = gender;
	}


	public String getEducation() {
		return education;
	}


	public void setEducation(String education) {
		this.education = education;
	}


	public String getSkill1() {
		return skill1;
	}


	public void setSkill1(String skill1) {
		this.skill1 = skill1;
	}


	public String getSkill2() {
		return skill2;
	}


	public void setSkill2(String skill2) {
		this.skill2 = skill2;
	}


	public String getSkill3() {
		return skill3;
	}


	public void setSkill3(String skill3) {
		this.skill3 = skill3;
	}


	public int getExperience() {
		return experience;
	}


	public void setExperience(int experience) {
		this.experience = experience;
	}


	public Blob getResume() {
		return resume;
	}


	public void setResume(Blob resume) {
		this.resume = resume;
	}


	public Map<Long, Application> getApplicationList() {
		return applicationList;
	}


	public void setApplicationList(Map<Long, Application> applicationList) {
		this.applicationList = applicationList;
	}
	
	
	
	
	
	
}
