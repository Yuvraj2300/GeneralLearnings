import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.RUNTIME)
@interface What {
	String desc();
}

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
	int val();

	String str();
}

@What(desc = "Testing annotations on class")
@MyAnno(val = 90, str = "TESTING ON CLASS")
class Meta2 {
	
	public static void main(String[] args) {
		myMeth();
	}
	

	@What(desc = "Testing annotations on method")
	@MyAnno(val = 90, str = "TESTING ON METHOD")
	public static void myMeth() {
		Meta2 ob = new Meta2();

		try {
			java.lang.annotation.Annotation[] annos = ob.getClass().getAnnotations();
			for (java.lang.annotation.Annotation anno : annos) {
				System.out.println(anno);
			}
			System.out.println();
			Method m = ob.getClass().getMethod("myMeth");
			annos = m.getAnnotations();
			for (java.lang.annotation.Annotation anno : annos) {
				System.out.println(anno);
			}

		} catch (Exception e) {

		}
	}
}


/*
class Meta {
	@MyAnno(val = 100, str = "THIS IS THE STRING GIVEN")
	public static void myMeth() {
		Meta ob = new Meta();

		try {
			Class<?> c = ob.getClass();
			Method m = c.getMethod("myMeth");
			MyAnno anno = m.getAnnotation(MyAnno.class);

			System.out.println(anno.str() + " " + anno.val());

		} catch (NoSuchMethodException e) {

		}
	}

}
*/