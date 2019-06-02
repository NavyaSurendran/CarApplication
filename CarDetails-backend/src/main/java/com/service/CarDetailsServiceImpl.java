package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.CarDetails;
import com.entity.CarShow;
import com.model.CarMaker;
import com.repository.CarDetailsRepository;

@Service
public class CarDetailsServiceImpl implements CarDetailsService{
	
	@Autowired
	CarDetailsRepository carDetailsRepository;

	@Override
	public List<CarShow> findAllCarShow() {
		List<CarShow> carShowList= new ArrayList<>();		
		carDetailsRepository.findAll().forEach(carShowList :: add);
		  return carShowList;
		
	}

	public Map<String, List<CarMaker>> getCarMakersDetails(List<CarShow> carShowList){
		List<CarMaker> carMakerList = new ArrayList<>();
		CarMaker maker;
		List<CarDetails> carDetailList = new ArrayList<>();
		for(CarShow show:carShowList) {
			carDetailList= show.getCarDetailsList();
			
			for(CarDetails car: carDetailList) {
				maker = new CarMaker();
				maker.setModel(car.getModel());
				maker.setName(car.getMake());
				maker.setShow(show.getShowName());
				carMakerList.add(maker);
			}
		}
		
		Map<String, List<CarMaker>> carModelMap= new HashMap<>();
		List<CarMaker> makeList = new ArrayList<>();
		
		for(int i=0; i< carMakerList.size(); i++) {
			for(int j=i+1; j< carMakerList.size(); j++) {
				if(carMakerList.get(i).getName().equals(carMakerList.get(j).getName())) {
					makeList.add(carMakerList.get(i));
					makeList.add(carMakerList.get(j));
					carModelMap.put(carMakerList.get(i).getName(), makeList);
					
				}
			}			
		}
		
		
		
		Map<String, List<CarMaker>> finalMap = new HashMap<>();
		
		List<CarMaker> list = new ArrayList<>();
		List<CarMaker> list2 = new ArrayList<>();
		
		for(Map.Entry<String, List<CarMaker>> entry : carModelMap.entrySet()) {
			list = ((List<CarMaker>)entry.getValue());
			for(int i=0; i<list.size(); i++) {
				for(int j=i+1; j<list.size(); j++) {
					if(list.get(i).getName().equals(list.get(j).getName())) {
						list2.add(list.get(i));
						list2.add(list.get(j));
						finalMap.put(list.get(i).getName(), list2);
						
					}
				}
			}
			
		}
		
		return finalMap;
	}

}
