package com.learn.FunctionalInter;

import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
interface Sayable {
	void say();
}

public class FunctionalInterfaceExample implements Sayable {
	public void say() {
		System.out.println("Saying!!!");
	}

	public static void main(String[] args) {
		Sayable sayO = () -> {
			System.out.println("YYOIL");
		};
		Function<Integer, Integer> fn = (x) -> {
			return x + 20;
		};
		
		Predicate<String> myPred= (s)->{
			return s.equals("S");
		};
		
		System.out.println(myPred.test("S"));
		System.out.println(fn.apply(20));
	}
}
