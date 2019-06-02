package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.CarDetails;
import com.entity.CarShow;

@Repository
public interface CarDetailsRepository  extends JpaRepository<CarShow, Integer>{
	
	List<CarShow> findAll();
}
