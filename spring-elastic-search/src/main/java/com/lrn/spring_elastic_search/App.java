package com.lrn.spring_elastic_search;

import java.util.Map;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import com.lrn.spring_elastic_search.model.Book;
import com.lrn.spring_elastic_search.service.BookService;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	private ElasticsearchOperations es;

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	@Override
	public void run(String... args) throws Exception {
		printElasticSearchInfo();

		bookService.save(new Book("1001", "Shoe Dog", "Phil Knight", "26-FEB-2019"));
		bookService.save(new Book("1002", "The God Father", "Mario Puzo", "26-FEB-2019"));
		bookService.save(new Book("1003", "My India", "Jim Corbett", "26-FEB-2019"));

		// fuzzey search
		Page<Book> books = bookService.findByAuthor("Phil Knight", new PageRequest(0, 10));

		// List<Book> books = bookService.findByTitle("Elasticsearch Basics");

		books.forEach(x -> System.out.println(x));
	}

	private void printElasticSearchInfo() {
		System.out.println("--ElasticSearch--");
		Client client = es.getClient();
		Map<String, Settings> asMap = client.settings().getAsGroups();

		asMap.forEach((k, v) -> {
			System.out.println(k + " = " + v);
		});
		
		System.out.println("--ElasticSearch--");
	}
}
