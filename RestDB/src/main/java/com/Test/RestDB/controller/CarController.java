package com.Test.RestDB.controller;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Test.RestDB.Reps.CarRepo;
import com.Test.RestDB.entity.Car;

@RestController
@RequestMapping("/testapi")
public class CarController {

	private	CarRepo	carRep;
	
	@GetMapping("/getCars")
	public	List<Car>	getAll(){
		return	carRep.findAll();
	}

	@Scheduled(fixedDelay=5000)
	public	void	test() {
		System.out.println("DIsplay after every 5 seconds");
	}
	
	
}
