package com.learn.LamdaExp;

import java.util.ArrayList;
import java.util.List;

public class LambdaForEach {
	public static void main(String[] args) {
		
		List<String>	nameList	=	new	ArrayList<String>();
		nameList.add("John");
		nameList.add("Joshua");
		nameList.add("Moshe");
		nameList.add("Iszak");
		nameList.add("Isabella");
		
		nameList.forEach((n)->{
			System.out.println(n);
		});
	
	}
}
