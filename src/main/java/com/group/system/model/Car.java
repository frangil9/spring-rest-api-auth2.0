package com.group.system.model;

import org.springframework.stereotype.Component;

/**
 * Created by fran.
 */
public class Car {

    private Integer carId;
    private int quanty;
    private String description;
    private double price;
    private double total;

    public Car() {
    }

	public Car(Integer carId, int quanty, String description, double price, double total) {
		super();
		this.carId = carId;
		this.quanty = quanty;
		this.description = description;
		this.price = price;
		this.total = total;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public int getQuanty() {
		return quanty;
	}

	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

  }
