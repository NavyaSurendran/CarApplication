package com.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.CarShow;
import com.model.CarMaker;
import com.service.CarDetailsService;

@RestController
@RequestMapping(path="/api/v1/cars")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:8080"})
public class CarDetailsController {

	@Autowired
	CarDetailsService carDetailsService;
	
	@GetMapping
	public ResponseEntity<?> fetchCarDetailsService(HttpServletRequest request, HttpServletResponse response){
		final List<CarShow> allShow = carDetailsService.findAllCarShow();	
		Map<String, List<CarMaker>> map = carDetailsService.getCarMakersDetails(allShow);
		return new ResponseEntity<Map<String, List<CarMaker>>>(map,HttpStatus.OK);
		
	}
}
