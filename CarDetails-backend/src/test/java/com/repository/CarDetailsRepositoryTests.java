package com.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.entity.CarDetails;
import com.entity.CarShow;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
@Transactional
public class CarDetailsRepositoryTests {
	
	@Autowired
	private CarDetailsRepository carDetailsRepository;

	public CarDetailsRepository getCarDetailsRepository() {
		return carDetailsRepository;
	}

	public void setCarDetailsRepository(CarDetailsRepository carDetailsRepository) {
		this.carDetailsRepository = carDetailsRepository;
	}

	@Test
	public void testFindAllCarDetails() throws Exception {
		
		
		
		List<CarDetails> carDetailsList = new ArrayList<CarDetails>();
		carDetailsList.add(new CarDetails("Audi", "A4"));
		carDetailsList.add(new CarDetails("BMW", "320d"));
		carDetailsList.add(new CarDetails("Benz", "345"));
		CarShow carShow = new CarShow("Formula 1", carDetailsList);
		
		carDetailsRepository.save(carShow);
		
		List<CarShow> carShowList = new ArrayList<>(); 
		carShowList = carDetailsRepository.findAll();
		assertThat(carShowList.size()).isGreaterThan(1);		
	}

}
