package lrn.kara.leet;

import java.util.ArrayList;
import java.util.List;

public class NPrime {
	public static void main(String[] args) {
		sieve(5);
	}

	static void sieve(int n) {
		int p = 2;
		List<Integer> prime = new ArrayList<>(3 * n);
		boolean[] primeArray = new boolean[3 * n];

		for (int i = 0; i < primeArray.length; i++) {
			primeArray[i] = true;
		}

//		for (int i = p * p; i < primeArray.length; i++) {
//			if (i % Math.sqrt(i) == 0) {
//				primeArray[i] = false;
//			}
//			p++;
//		}
		int i = 2;
		while (i < primeArray.length) {
			for (int j = i * i; j < primeArray.length; j = j + (i)) {
				if (primeArray[j-1] = true) {
					primeArray[j-1] = false;
				}

			}
			i++;
		}

		for (int j = 1; j < primeArray.length; j++) {
			if (primeArray[j] = true) {
				prime.add(j+1);
			}
		}

	}
}
