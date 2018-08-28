/*package com.Test.RestDB.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Test.RestDB.Reps.CarRepo;
import com.Test.RestDB.entity.Car;

@Service("carService")
@Transactional
public class CarService {
	@Autowired
	private CarRepo carRep;

	Logger logger;

	@Scheduled(fixedDelay=5000)
	public void updateCarAgeJob() {
		List<Car> cars = carRep.findAll();

		DateTime currentTime = DateTime.now();

		logger.info("Car update job started");

		cars.forEach(car -> {
			int age = Years.yearsBetween(car.getManufacturedate(), currentTime).getYears();
			
			car.setAge(age);
			carRep.save(car);
			logger.info("Car age update -->> "+car);
		});

		logger.info("Car update done successfully");
	}

}
*/