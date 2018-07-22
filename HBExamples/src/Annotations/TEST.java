package Annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

public class TEST {
	public static void main(String[] args) {
		Meta2.myMeth();
	}
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
	String str() default "DEFAULTaVA";

	int val() default 10000;
}

@interface	Value{
	int	value();
}

class	Meta2{
	@Value(5000)
	public	static	void	myMeth() {
		Meta2	ob	=	new	Meta2();
		try {
			Method	m	=	ob.getClass().getMethod("myMeth");
			Value	v	=	m.getAnnotation(Value.class);
			System.out.println(v.value());
			
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Meta {

	@MyAnno
	public	static	void	myMeth() {
	Meta	ob	=	new	Meta();
	try {
		Class<?>	c	=	ob.getClass();
		Method	m	=	c.getMethod("myMeth");
		MyAnno	anno	=	m.getAnnotation(MyAnno.class);
		System.out.println(anno.str()+"  "+anno.val());
	}catch(Exception	e) {
		
		}
	}
	
	
}
