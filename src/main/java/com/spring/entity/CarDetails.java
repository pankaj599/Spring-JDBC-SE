package com.spring.entity;

import org.springframework.stereotype.Component;

@Component
public class CarDetails {
	private int id;
	private String colour;
	private int costOfCar;
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public int getCostOfCar() {
		return costOfCar;
	}
	public void setCostOfCar(int costOfCar) {
		this.costOfCar = costOfCar;
	}

	public CarDetails() {
		super();
		//System.out.println("object is created");
	}
	public CarDetails(int id, String colour, int costOfCar, String name) {
		super();
		this.id = id;
		this.colour = colour;
		this.costOfCar = costOfCar;
		this.name = name;
	}
	@Override
	public String toString() {
		return "CarDetails [id=" + id + ", colour=" + colour + ", costOfCar=" + costOfCar + ", name=" + name + "]";
	}

}
