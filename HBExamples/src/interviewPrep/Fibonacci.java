package interviewPrep;

//0 1 1 2 3 5 8 13 21....

public class Fibonacci {
	public static void main(String[] args) {
		int n1=0;
		int n2=1;
		int	n3;
		System.out.print(n1+" ");
		System.out.print(n2+" ");
		
		for(int	i=2;i<15;i++) {
			n3	=	n1+n2;
			n1=n2;
			n2=n3;
			System.out.print(n3+" ");
		}
	}
}