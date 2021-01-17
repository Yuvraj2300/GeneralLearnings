package pakcage_32;

public class Block {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NumFact fact = (n) -> {
			int result = 1;

			for (int i = 1; i <= n; i++) {
				result = result * i;
			}

			return result;
		};

		System.out.println(fact.funct(4));
		System.out.println(fact.funct(5));
	}
}

interface NumFact {
	int funct(int n);
}
