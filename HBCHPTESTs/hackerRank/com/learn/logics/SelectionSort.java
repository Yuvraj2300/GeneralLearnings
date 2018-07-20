package com.learn.logics;

public class SelectionSort {
	public static void main(String[] args) {
		Integer[]	inp	=	{123,45,2,133,788};
		
		int	smallestNum;
		int	index;
		
		for(int	i=0;i<inp.length;i++) {
			index	=	i;
			for(int	j=i+1;j<inp.length;j++) {
				if(inp[j]<inp[i]) {
					index=j;
				}
				smallestNum	=	inp[index];
				inp[index]	=	inp[i];
				inp[i]	=	smallestNum;
			}
		}
		
		for(Integer	i	:	inp) {
			System.out.print(i+" ");
		}
		

	}
}
