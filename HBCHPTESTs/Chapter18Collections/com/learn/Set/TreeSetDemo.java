package com.learn.Set;

import java.util.TreeSet;

public class TreeSetDemo {
	public static void main(String[] args) {
		TreeSet<String>	ts	=	new	TreeSet<>();
		ts.add("Z");
		ts.add("C");
		ts.add("A");
		ts.add("E");
		ts.add("D");
		ts.add("G");
		
		System.out.println(ts);
		System.out.println(ts.subSet("A", "H"));
		
	}
}
