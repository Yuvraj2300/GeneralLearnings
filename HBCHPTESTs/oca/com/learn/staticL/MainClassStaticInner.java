package com.learn.staticL;

import com.learn.staticL.OuterClassStaticInner.InnerStatic;

public class MainClassStaticInner {
	public static void main(String[] args) {
		
		OuterClassStaticInner.InnerStatic	outer	=	new	OuterClassStaticInner.InnerStatic();
		outer.display();
	}
}
