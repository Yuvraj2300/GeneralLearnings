package interviewPrep;

import java.util.Scanner;

public class Prime {
	
	static	public	Scanner	sc		=	new	Scanner(System.in);
	public static void main(String[] args) {
		int	in	=	sc.nextInt();
		
		if(in%2==0) {
			System.out.println("Prime");
		}else {
			System.out.println("Not Prime");
		}
		
	}
	
}
