package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entity.Application;

@Repository
public interface ApplicationRepo extends JpaRepository<Application, Long> {

}
