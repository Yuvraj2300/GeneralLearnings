package pakcage_32;

public class Generic {
	public static void main(String[] args) {
		SomeFunct<String> someF1 = (s) -> {
			StringBuilder sb = new StringBuilder(s);
			sb.reverse();
			return sb.toString();
		};

		System.out.println(someF1.funct("Yuvraj"));

		SomeFunct<Integer> someF2 = (n) -> {
			int result = 1;

			for (int i = 1; i <= n; i++) {
				result = result * i;
			}

			return result;
		};

		System.out.println(someF2.funct(5));
	}

}

interface SomeFunct<T> {
	T funct(T t);
}
