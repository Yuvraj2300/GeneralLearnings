package com.test.pojo;

import java.util.List;
import java.util.function.Predicate;

/*Product(name, color, size)
Color -> Red, Blue, Green
Size -> Small, Medium, Large

filter by attributes Color, Size etc. 
	--> I/t -- List of products
 	--> O/t -- Products matching criteria
	*/

public class Product {
	private String name;
	private Colors color;
	private String size;

	public Product(String name, Colors color, String size) {
		super();
		this.name = name;
		this.color = color;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public Colors getColor() {
		return color;
	}

	/*
	 * public void setColor(Colors color) { this.color = color; }
	 */
	public String getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", color=" + color + ", size=" + size + "]";
	}

	static public void match(List<Product> products, Predicate<Product> condition) {
		for (Product p : products) {
			if (condition.test(p)) {
				System.out.println(p.toString());
			}
		}

	}
}
