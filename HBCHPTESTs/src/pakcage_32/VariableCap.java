package pakcage_32;

public class VariableCap {
	public static void main(String[] args) {
		int num = 10;

		myInt myLamb = (n) -> {
			int a = n + num;
			// num++;
			return a;
		};

//	num++;
//		num = 100;
	}
}

interface myInt {
	int funt(int n);
}
