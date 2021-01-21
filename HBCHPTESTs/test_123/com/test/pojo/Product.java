package com.test.pojo;

import java.util.function.Predicate;

/*Product(name, color, size)
Color -> Red, Blue, Green
Size -> Small, Medium, Large

filter by attributes Color, Size etc. 
	--> I/t -- List of products
 	--> O/t -- Products matching criteria
	*/

public class Product implements Predicate<MatchingCriteria>{
	private String name;
	private Colors color;
	private String size;

	public String getName() {
		return name;
	}

	public Colors getColor() {
		return color;
	}
/*
	public void setColor(Colors color) {
		this.color = color;
	}
*/
	public String getSize() {
		return size;
	}
	

	@Override
	public boolean test(MatchingCriteria t) {
		this.getColor().equals(t.)
		return false;
	}
}
