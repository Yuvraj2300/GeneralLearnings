package com.lrn;

class TwoD {
	int x;
	int y;

	public TwoD(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

class ThreeD extends TwoD {
	int z;

	public ThreeD(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
}

class FourD extends ThreeD {
	int t;

	public FourD(int x, int y, int z, int t) {
		super(x, y, z);
		this.t = t;
	}
}

public class Coords<T extends TwoD> {
	T[] coords;

	public Coords(T[] coords) {
		super();
		this.coords = coords;
	}

	public static void showCoords(Coords<?> c) {
		for (int i = 0; i < c.coords.length; i++) {
			System.out.println(c.coords[i].x);
		}
	}

	public static void showCoordsThree(Coords<? extends TwoD> c) {
		for (int i = 0; i < c.coords.length; i++) {
			System.out.println(c.coords[i].x);
		}
	}
	
	public static void main(String[] args) {
		ThreeD td = new ThreeD(1, 2, 2);
		ThreeD[] threeD	=	{td};
		Coords<ThreeD> tdc	=	new	Coords<>(threeD);
		showCoords(tdc);
	}

}
