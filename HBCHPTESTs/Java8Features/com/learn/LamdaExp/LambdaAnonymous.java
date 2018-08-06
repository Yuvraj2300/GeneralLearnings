package com.learn.LamdaExp;

interface	Drawable{
	void	draw();
}

public class LambdaAnonymous {
	public static void main(String[] args) {
		
		Drawable	d1	=	new	Drawable() {
			//WITHOUT LAMBDA HAD TO IMPLEMENT AN ANNONYMOUS CLASS,.....
			int	width	=	19;
			public	void	draw() {
				System.out.println("Drawing !!!"+width);
			}
		};
		
		d1.draw();
	}
}
