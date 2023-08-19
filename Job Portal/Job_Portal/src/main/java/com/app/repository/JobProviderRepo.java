package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.JobProvider;

@Repository
public interface JobProviderRepo extends JpaRepository<JobProvider, Long> {

}
