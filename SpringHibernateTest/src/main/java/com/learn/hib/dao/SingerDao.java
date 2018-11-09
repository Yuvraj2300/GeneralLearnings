package com.learn.hib.dao;

import java.util.List;

import com.learn.hib.entities.Singer;

public interface SingerDao {
	List<Singer> findAll();

	List<Singer> findAllWithAlbum();

	Singer findById(Long id);

	Singer save(Singer contact);

	void delete(Singer contact);
}
