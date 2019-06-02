package com.service;

import java.util.List;
import java.util.Map;

import com.entity.CarShow;
import com.model.CarMaker;

public interface CarDetailsService {
	
	public List<CarShow> findAllCarShow();

	public Map<String, List<CarMaker>> getCarMakersDetails(List<CarShow> carShowList);
	
}
