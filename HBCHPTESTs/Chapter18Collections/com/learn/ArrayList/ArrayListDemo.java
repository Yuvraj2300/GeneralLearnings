package com.learn.ArrayList;

import java.util.ArrayList;

public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList<String>		a1	=	new	ArrayList<>();
		
		System.out.println("Size b4 addition: "+a1.size());
		
		a1.add("A");
		a1.add("B");
		a1.add("C");
		a1.add("D");
		a1.add("E");
		a1.add("F");
		
		System.out.println("Size after addition: "+a1.size());
		
		System.out.println(a1);
		
		a1.set(1, "A2");
	
		System.out.println(a1);
	}
}
