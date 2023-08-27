package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Application;
import com.app.entity.Job;

@Repository
public interface ApplicationRepo extends JpaRepository<Application, Long> {
	List<Application> findByAssignedJobId(Job jobId);
}
