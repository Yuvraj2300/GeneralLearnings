package com.learn.logics;

import java.util.Scanner;

public class Factorial {
	public	static	Scanner	sc	=	new	Scanner(System.in);
	public static void main(String[] args) {
		int	n	=	sc.nextInt();
		int	res	=	n;
		while(n>1) {
			System.out.println(n);
			res	=	res	*	--n;
			System.out.println(n);
		}
		System.out.println("factorial :" +res);
	}
}
