package com.learn.logics;

public class Test {
	
	public static void main(String[] args) {
		int	num	=	25;
		genFib(num);
	}
	
	public	static	void	genFibRec(int	num) {
		int	i=0;
		int	j=1;
		int	sum	=	0;
		System.out.println(i);
		while(j<num) {
			sum	=	i+j;
			System.out.print(sum+" ");
			i	=	j;
			j	=	sum;
		}
	}
	
	public	static	void	genFib(int	num) {
		int	i	=	0;
		int	j	=	1;
		int	sum	=	0;
		System.out.print(i+" ");
		while(j<num) {
			sum	=	i+j;
			System.out.print(sum+" ");
			i	=	j;
			j	=	sum;
		}
	}
}
