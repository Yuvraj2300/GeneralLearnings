package interviewPrep;

import java.util.Scanner;

public class Swap {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int	n1	=	sc.nextInt();
		int	n2	=	sc.nextInt();
		
		System.out.println("Value of n2: "+n2);
		System.out.println("Value of n1: "+n1);
		
		n1	=	n1+n2;
		System.out.println("Value of n1 now after addition: "+n1);
		n2	=	n1-n2;
		System.out.println("Value of n2 now: "+n2);
		n1	=	n1-n2;
		System.out.println("Value of n1 now: "+n1);
		
	}
}
