package pakcage2;

import java.util.HashMap;

class A_222 {
	int V;

	@Override
	public int hashCode() {
		return 1;
	}

	public boolean equals(int v) {
		if (this.V == v) {
			return true;
		} else {
			return false;
		}
	}

}

public class Test {
	public static void main(String[] args) {
		HashMap<A_222, Integer> hm = new HashMap<>();
		hm.put(new A_222(), 1);
		hm.put(new A_222(), hm.get(A_222())+1);
	}

}
