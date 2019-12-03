package com.lrn.spring_elastic_search.service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lrn.spring_elastic_search.model.Book;
import com.lrn.spring_elastic_search.repo.BookRepo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRep;

	@Override
	public Book save(Book book) {
		return bookRep.save(book);
	}

	@Override
	public void delete(Book book) {
		// TODO Auto-generated method stub
		bookRep.delete(book);
	}

	/*@Override
	public Book findOne(String id) {
		// TODO Auto-generated method stub
		return bookRep. findOne(id);
	}*/

	@Override
	public Iterable<Book> findAll() {
		// TODO Auto-generated method stub
		return bookRep.findAll();
	}

	@Override
	 public Page<Book> findByAuthor(String author, PageRequest pageRequest) {
	        return bookRep.findByAuthor(author, (Pageable) pageRequest);
	    }

	@Override
	public List<Book> findByTitle(String title) {
		return bookRep.findByTitle(title);
	}

	@Override
	public Book findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
