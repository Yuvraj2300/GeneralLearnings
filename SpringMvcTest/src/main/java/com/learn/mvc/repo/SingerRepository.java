package com.learn.mvc.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.learn.mvc.entities.Singer;


@Repository
public interface SingerRepository extends PagingAndSortingRepository<Singer, Long> {

}
