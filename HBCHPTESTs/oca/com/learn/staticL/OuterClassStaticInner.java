package com.learn.staticL;

class OuterClassStaticInner {
	static	int	val1	=	1;
	int	val2	=	2;
	static	int	val3	=	3;
	
	static	class	InnerStatic{
		void	display(){
			System.out.println(val1);
		//	System.out.println(val2);
		}
	}
}


