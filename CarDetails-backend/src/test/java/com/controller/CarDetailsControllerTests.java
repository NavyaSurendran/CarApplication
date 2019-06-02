package com.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.entity.CarDetails;
import com.entity.CarShow;
import com.service.CarDetailsService;

@RunWith(SpringRunner.class)
@WebMvcTest(CarDetailsController.class)
public class CarDetailsControllerTests {

	@Autowired
	private transient MockMvc mvc;
	
	@MockBean
	private transient CarDetailsService carDetailsService;
	
	@InjectMocks
	private CarDetailsController controller;
		
	static List<CarShow> carShowList;	
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		carShowList = new ArrayList<>();
		List<CarDetails> carDetailsList = new ArrayList<CarDetails>();
		carDetailsList.add(new CarDetails("Audi", "A4"));
		carDetailsList.add(new CarDetails("BMW", "320d"));
		carDetailsList.add(new CarDetails("Benz", "345"));
		CarShow carShow = new CarShow("Formula 1", carDetailsList);
		carShowList.add(carShow);
	}
	
	@Test
	public void testFetchCarDetailsServiceTest() throws Exception {
		
		when(carDetailsService.findAllCarShow()).thenReturn(carShowList);
		mvc.perform(get("/api/v1/cars")
				.header("authorization", "Bearer ")
				.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
		verify(carDetailsService, times(1)).findAllCarShow();
		verifyNoMoreInteractions(carDetailsService);
	}


	

}
