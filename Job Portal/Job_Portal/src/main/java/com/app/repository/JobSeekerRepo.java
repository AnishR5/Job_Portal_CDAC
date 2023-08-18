package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.JobSeeker;

@Repository
public interface JobSeekerRepo extends JpaRepository<JobSeeker, Long> {

}
