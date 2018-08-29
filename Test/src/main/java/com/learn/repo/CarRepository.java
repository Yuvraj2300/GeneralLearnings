package com.learn.repo;

import org.springframework.data.repository.CrudRepository;

import com.learn.entity.Car;

public interface CarRepository	extends	CrudRepository<Car, Long> {

}
