package com.lrn.spring_elastic_search.repo;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.lrn.spring_elastic_search.model.Book;

public interface BookRepo extends ElasticsearchRepository<Book, String> {
	Page<Book> findByAuthor(String author, Pageable pageable);

	List<Book> findByTitle(String title);
}
