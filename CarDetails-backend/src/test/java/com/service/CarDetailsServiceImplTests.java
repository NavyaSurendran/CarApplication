package com.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.entity.CarDetails;
import com.entity.CarShow;
import com.model.CarMaker;
import com.repository.CarDetailsRepository;

public class CarDetailsServiceImplTests {

	@Mock
	private CarDetailsRepository carDetailsRepository;
	
	private transient List<CarShow> carShowList;
	
	private CarDetails carDetails;
	
	@InjectMocks
	private CarDetailsServiceImpl carDetailsService;
	
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		List<CarShow> carShowList = new ArrayList<>(); 
		
		List<CarDetails> carDetailsList = new ArrayList<CarDetails>();
		carDetailsList.add(new CarDetails("Audi", "A4"));
		carDetailsList.add(new CarDetails("BMW", "320d"));
		carDetailsList.add(new CarDetails("Benz", "345"));
		CarShow carShow = new CarShow("Formula 1", carDetailsList);
		carShowList.add(carShow);
		
		
	}
	
	@Test
	public void testMockCreation() {
		assertNotNull("JPA repo creation failed", carDetails);
	}
	
	@Test
	public void testFindAllCarDetails() {
		when(carDetailsRepository.findAll()).thenReturn(carShowList);		
		List<CarShow> carShows = carDetailsService.findAllCarShow();
		assertEquals("fetching all Car Details  failed",carShows.size(), carShowList.size());		
		verify(carDetailsRepository,times(1)).findAll();		
	}
	
	@Test
	public void testGetCarMakersDetails() {
		carShowList= new ArrayList<>();
		List<CarDetails> carDetailsList = new ArrayList<CarDetails>();
		carDetailsList.add(new CarDetails("Audi", "A4"));
		carDetailsList.add(new CarDetails("BMW", "320d"));
		carDetailsList.add(new CarDetails("Benz", "345"));
		CarShow carShow = new CarShow("Formula 1", carDetailsList);
		CarShow carShow2 = new CarShow("Alpha show", carDetailsList);
		carShowList.add(carShow);
		carShowList.add(carShow2);
		Map<String, List<CarMaker>> map=carDetailsService.getCarMakersDetails(carShowList);
		assertNotNull(map);
	}




}
