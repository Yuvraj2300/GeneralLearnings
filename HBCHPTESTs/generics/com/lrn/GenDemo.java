package com.lrn;

class Gen<Z, T> {
	Z ob;
	T ob1;

	public Gen(Z ob, T ob1) {
		super();
		this.ob = ob;
		this.ob1 = ob1;
	}

	Z getOb() {
		return ob;
	}

	T getOb1() {
		return ob1;
	}

	void showType_1() {
		System.out.println("Type of T is " + ob.getClass().getName());
	}

	void showType_2() {
		System.out.println("Type of T is " + ob1.getClass().getName());
	}

}

public class GenDemo {
	public static void main(String[] args) {
		Gen<Integer, Integer> iOb;
		iOb = new Gen<>(10, 43);
		iOb.showType_1();
		iOb.showType_2();
		System.out.println(iOb.getOb());
		System.out.println(iOb.getOb1());

		/*
		 * iOb.showType(); System.out.println(iOb.getOb()); int v =
		 * iOb.getOb().intValue();
		 */
		/*
		 * Gen<String> sOb; sOb = new Gen<>("Yuvraj"); sOb.showType();
		 * System.out.println(sOb.getOb());
		 */
		
		
		
	}
}
