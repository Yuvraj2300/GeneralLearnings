package herbert.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionDemo {
	public static void main(String[] args) {
		try {
			Class<?>	c	=	Class.forName("java.awt.Dimension");
			System.out.println("Constructors:- ");
			Constructor<?>[]	constructors	=	c.getConstructors();
			for(Constructor<?>	co:constructors) {
				System.out.println(co);
			}
			
			System.out.println();
			System.out.println("Fields:- ");
			Field[]	fields	=	c.getFields();
			for(Field	f:fields) {
				System.out.println(f);
			}
			
			System.out.println();
			System.out.println("Methods:- ");
			Method[]	methods	=	c.getDeclaredMethods();
			for(Method	m:methods) {
				System.out.println(m);
			}
			
		}catch(Exception	e) {
			e.getMessage();
		}
	}
}
