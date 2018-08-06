package com.learn.LamdaExp;

interface	Drawable_L {
	void	draw();
}

public class LamdaDemo {
	public static void main(String[] args) {

		Drawable_L d2 = () -> {
			System.out.println("Drawing");
		};

		d2.draw();

	}

}
