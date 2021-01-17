package com.lrn;

interface MyInt<T extends Comparable<T>> {
	T min();

	T max();
}

public class MyClass<T extends Comparable<T>> implements MyInt<T> {

	T[] vals;

	public MyClass(T[] vals) {
		super();
		this.vals = vals;
	}

	@Override
	public T min() {
		T v = vals[0];

		for (int i = 0; i < vals.length; i++) {
			if (vals[i].compareTo(v) < 0)
				v = vals[i];
		}
		return v;
	}

	@Override
	public T max() {
		T v = vals[0];

		for (int i = 0; i < vals.length; i++) {
			if (vals[i].compareTo(v) > 0)
				v = vals[i];
		}
		return v;
	}

	public static void main(String[] args) {
		Integer nums[] = { 1, 323, 4, 5, 2 };
		Character ch[] = { 'a', 'd', 't', 'z' };

		MyInt<Integer> iob = new MyClass<>(nums);
		MyInt<Character> cob = new MyClass<>(ch);

		System.out.println(iob.max());
		System.out.println(iob.min());
		System.out.println();
		System.out.println(cob.max());
		System.out.println(cob.min());
	}

}
