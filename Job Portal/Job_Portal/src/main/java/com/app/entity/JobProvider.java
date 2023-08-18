package com.app.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Setter
@Table(name = "jobprovider")
public class JobProvider {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long jpId;
	@Column(length = 40, nullable = false)
	private String jpName;
	@Column(length = 40, nullable = false,unique = true)
	private String userName;
	@Column(length = 40, nullable = false)
	private String password;
	@Email
	@Column(unique = true, length=100)
	private String email;
	@Column(length = 300, nullable = false)
	private String address;
	@Column(length = 100)
	private String webSite;
	@Column(length = 40, nullable = false,unique = true)
	private String phoneNo;
	@OneToMany(mappedBy = "jpId",cascade = CascadeType.ALL,orphanRemoval = true)
	private Map<Long,Job> jobList=new HashMap<Long,Job>();

}
