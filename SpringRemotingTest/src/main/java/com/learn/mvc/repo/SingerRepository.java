package com.learn.mvc.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learn.mvc.entities.Singer;


@Repository
public interface SingerRepository extends	CrudRepository<Singer, Long> {
	List<Singer>	findByFirstName(String	firstName);
}
