package com.learn.LamdaExp;

interface Sayable {
	String say(String words);
}

public class LambdaDemoSinglePara {
	public static void main(String[] args) {
		
		Sayable s1 = (name) -> {
			return "Hello " + name;
		};
		
		System.out.println(s1.say("Yuvraj"));
	}
}
