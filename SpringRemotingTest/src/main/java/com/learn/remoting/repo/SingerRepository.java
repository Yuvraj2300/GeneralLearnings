package com.learn.remoting.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learn.remoting.entities.Singer;


@Repository
public interface SingerRepository extends	CrudRepository<Singer, Long> {
	List<Singer>	findByFirstName(String	firstName);
}
