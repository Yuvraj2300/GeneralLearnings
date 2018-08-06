package com.learn.MethodReference;

interface	Sayable{
	void	say();
}

public class MethodReference1 {
	
	
	public MethodReference1() {
		System.out.println("Saying in construnctor");
	}
	
	public	void	saySome1() {
		System.out.println("Saying in instance");
	}
	
	public	static	void	saySome() {
		System.out.println("Saying Bro");
	}
	
	public static void main(String[] args) {
		
		Sayable	say2	=	MethodReference1::new;
		
		Sayable	say1	=	new	MethodReference1()::saySome1;
		say1.say();
		
		Sayable	say	=	MethodReference1::saySome;
		say.say();
	}
}
