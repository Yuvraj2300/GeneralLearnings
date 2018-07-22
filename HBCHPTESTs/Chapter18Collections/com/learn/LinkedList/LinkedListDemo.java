package com.learn.LinkedList;

import java.util.LinkedList;

public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedList<String>	linkL	=	new	LinkedList<>();
		
		linkL.add("A2");
		linkL.add("B");
		linkL.add("C");
		linkL.add("D");
		linkL.add("E");
		linkL.add("F");
		linkL.add("G");
		linkL.addFirst("A");
		linkL.addLast("Z");
		
		System.out.println(linkL);
		
		linkL.set(1, "A3");
		
		System.out.println(linkL);
		
		linkL.removeLast();
		linkL.removeFirst();
		
		System.out.println(linkL);
		
	}
}
