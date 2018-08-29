package com.learn.services;

import java.util.List;

import com.learn.entity.Car;

public interface CarService {
	List<Car> findAll();

	Car save(Car car);

	void updateCarAgeJob();

	boolean isDone();
}
