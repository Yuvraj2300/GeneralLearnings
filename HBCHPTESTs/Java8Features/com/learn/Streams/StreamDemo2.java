package com.learn.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamDemo2 {
	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<>();
		myList.add(24);
		myList.add(1);
		myList.add(34);
		myList.add(43);
		myList.add(32);
		myList.add(18);
		myList.add(7);
		
		Optional<Integer>	productObj	=	myList.stream().reduce((a,b)-> a*b);
		if(productObj.isPresent())
			System.out.println(productObj.get());
		
		System.out.println();
		
		int	prod	=	myList.stream().reduce(1, (a,b)->a*b);
		System.out.println(prod);
	}
}
