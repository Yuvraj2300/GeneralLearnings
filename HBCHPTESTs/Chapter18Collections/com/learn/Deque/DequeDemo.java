package com.learn.Deque;

import java.util.ArrayDeque;

public class DequeDemo {
	public static void main(String[] args) {
		ArrayDeque<String>	ad	=	new	ArrayDeque<>();
		ad.push("A");
		ad.push("B");
		ad.push("C");
		ad.push("D");
		ad.push("E");
		ad.push("F");
		ad.push("G");
		
		System.out.println(ad);
		
		while(ad.peek()!=null) {
			System.out.println(ad.pop());
		}
	}
}
