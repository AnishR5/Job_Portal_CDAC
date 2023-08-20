package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Job;

@Repository
public interface JobRepo extends JpaRepository<Job, Long>{

}
