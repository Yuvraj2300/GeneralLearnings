package com.learn.mvc.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.learn.mvc.entities.Singer;

public interface SingerService {
	List<Singer> findAll();

	Singer findById(Long id);
	
	void	delete(Singer	singer);

	Singer save(Singer singer);

	Page<Singer> findAllByPage(Pageable pageable);	
}