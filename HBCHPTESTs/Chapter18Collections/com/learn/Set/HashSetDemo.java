package com.learn.Set;

import java.util.HashSet;

public class HashSetDemo {
	public static void main(String[] args) {
		HashSet<String>	hs		=	new	HashSet<>();
		hs.add("Alpha");
		hs.add("Beta");
		hs.add("Gamma");
		hs.add("Epsilon");
		hs.add("Omega");
		hs.add("Alpha");
		
		System.out.println(hs);
	}
}
