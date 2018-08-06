package com.learn.Optional;
import java.util.*;

public class OptionalDemo {
	public static void main(String[] args) {
		Optional<String>	noVal	=	Optional.empty();
		Optional<String>	hasVal	=	Optional.of("ABCDE");
	
		if(noVal.isPresent())
			System.out.println("Values are there");
		else	System.out.println("No vals there");
		
		if(hasVal.isPresent())	System.out.println("Value in hasVal :"+hasVal.get());

		String	defStr	=	noVal.orElse("No val");
		System.out.println(defStr);
		
	}
}
