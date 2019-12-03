package lrn.kara.recursion;

public class Fibonacci {
	
	public static void main(String[] args) {
		int n	=	8;
		System.out.println("\nLast fib element :- "+iterative(n));
		//System.out.println("\nLast fib element :- "+recursive(n));
	}
	

	public static int iterative(int n) {
		if (n <=1) {
			System.out.print(n + " ");
			return n;
		} else {
			int f1 = 0, f2 = 1;
			int f = 0;
			for (int i = 0; i < n; i++) {
				f = f1 + f2;
				System.out.print(f1 + ", " + f2);
				f1 = f2;
				f2 = f;
			}
			return f;
		}
	}
	
	public static int recursive(int n) {
		if(n<=1) {
			return n;
		}else {
			System.out.print((n-1) + ", " + (n-2));
			return recursive(n-1)+recursive(n-2);
		}
	}

}
