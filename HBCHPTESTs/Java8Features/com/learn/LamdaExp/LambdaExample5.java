package com.learn.LamdaExp;

interface	Mathematical{
	int	intOp(int	a,int	b);
}

public class LambdaExample5 {
	public static void main(String[] args) {
		
		Mathematical	m	=	(a,b)->(a+b);
		
		Mathematical	m1	=	(a,b)->{
			return	a+b;
		};
		
		System.out.println(m.intOp(10, 20));
		System.out.println(m1.intOp(20, 20));
		
	}
}
