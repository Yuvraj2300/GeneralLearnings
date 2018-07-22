package interviewPrep;

import java.util.Scanner;

public class Palindrome {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		String	original,reverse="";
		int	i;
		
		original	=	sc.nextLine();
		i	=	original.length();
		
		while(i>0) {
			reverse=reverse+original.charAt(i-1);
			i--;
		}
		
		if(!original.equals(reverse)) {
			System.out.println("Not a palidrome");
		}else {
			System.out.println("A palidrome");
		}
	}
}
