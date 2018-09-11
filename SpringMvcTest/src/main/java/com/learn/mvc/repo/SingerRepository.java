package com.learn.mvc.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.learn.mvc.entites.Singer;

public interface SingerRepository extends PagingAndSortingRepository<Singer, Long> {

}
