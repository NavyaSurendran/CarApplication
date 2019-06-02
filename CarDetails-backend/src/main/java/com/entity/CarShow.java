package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="car_show")
public class CarShow {
	
	@Id
    @Column(name = "car_show_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "show_name")
	String showName;
	
	@OneToMany
	@Column(name ="car")
	private List<CarDetails> carDetailsList= new ArrayList<>();

	public CarShow() {
	}
	
	public CarShow(String showName, List<CarDetails> carDetailsList) {
		this.showName = showName;
		this.carDetailsList = carDetailsList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}
	
	public List<CarDetails> getCarDetailsList() {
		return carDetailsList;
	}

	public void setCarDetailsList(List<CarDetails> carDetailsList) {
		this.carDetailsList = carDetailsList;
	}

}
