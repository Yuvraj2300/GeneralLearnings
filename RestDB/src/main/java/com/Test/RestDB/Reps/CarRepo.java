package com.Test.RestDB.Reps;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Test.RestDB.entity.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {

}
