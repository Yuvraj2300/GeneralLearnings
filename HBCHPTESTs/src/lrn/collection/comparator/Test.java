package lrn.collection.comparator;

public class Test {
	public static void main(String[] args) {
		int a = 0;
		int b = 0;

		System.out.println(check(a, b));
	}

	static int check(int a, int b) {
		try {
			int r = a / b;
		} catch (RuntimeException re) {
			return 1;
		}

		/*
		 * catch (ArithmeticException e) { // TODO: handle exception return 2; }
		 */

		finally {
			System.out.println("done");
			return -111;
		}
	}
}
