package com.learn.LamdaExp;

interface	Sayable_L{
	String	say(String	words,String	name);
}

public class LambdaMultiplePara {
	public static void main(String[] args) {
		
		Sayable_L s = (words, name) -> {
			return words + " " + name;
		};
		
		System.out.println(s.say("Please realease", "Yuvraj Sharma."));
	}
}
