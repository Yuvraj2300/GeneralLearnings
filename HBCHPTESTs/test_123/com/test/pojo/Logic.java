package com.test.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Logic {

	public static void main(String[] args) {

		List<Product> products = new ArrayList<>();
		products.add(new Product("A", Colors.GREEN, "Large"));
		products.add(new Product("B", Colors.RED, "Medium"));
		products.add(new Product("C", Colors.RED, "Medium"));
		products.add(new Product("B", Colors.BLUE, "Small"));

		Predicate<Product> redColor = (p) -> {
			return p.getColor().equals(Colors.RED);
		};

		Predicate<Product> medSize = (p) -> {
			return p.getSize().equalsIgnoreCase("medium");
		};

		System.out.println("With Medium size");
		Product.match(products, medSize);
		System.out.println("With Red color");
		Product.match(products, redColor);
	}

}
