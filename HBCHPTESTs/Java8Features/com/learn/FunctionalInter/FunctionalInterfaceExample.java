package com.learn.FunctionalInter;


@FunctionalInterface
interface Sayable {
	void say();
}

public class FunctionalInterfaceExample implements	Sayable{
	public	void	say() {
		System.out.println("Saying!!!");
	}
	
	public static void main(String[] args) {
		FunctionalInterfaceExample	fie	=	new	FunctionalInterfaceExample();
		fie.say();
	}
}
