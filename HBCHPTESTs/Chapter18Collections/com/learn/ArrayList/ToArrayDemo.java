package com.learn.ArrayList;

import java.util.ArrayList;

public class ToArrayDemo {
	public static void main(String[] args) {
		ArrayList<Integer>	a1	=	new	ArrayList<>();
		
		a1.add(1);
		a1.add(2);
		a1.add(3);
		a1.add(4);
		
		System.out.println("Contents of AL: "+a1);
		
		Integer[]	ia	=	new	Integer[a1.size()];
		ia	=	a1.toArray(ia);
		int	sum	=	0;
		
		for(int	i:ia) {
			sum=sum+i;
			System.out.println(sum);
		}
	}
}
