package com.lrn.spring_elastic_search.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.lrn.spring_elastic_search.model.Book;
import com.lrn.spring_elastic_search.repo.BookRepo;

@Component
public interface BookService{
	Book save(Book book);

	void delete(Book book);

	Book findOne(String id);

	Iterable<Book> findAll();

	Page<Book> findByAuthor(String author, PageRequest pageRequest);

	List<Book> findByTitle(String title);
}