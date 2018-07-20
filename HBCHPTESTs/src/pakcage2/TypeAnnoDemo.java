package pakcage2;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;


@Target(ElementType.TYPE_USE)
@interface	TypeAnno{
	
}

@Target(ElementType.TYPE_USE)
@interface	NotZeroLen{
	
}

@Target(ElementType.TYPE_USE)
@interface	Unique{
	
}

@Target(ElementType.TYPE_USE)
@interface		MaxLen{
	int	value();
}

@Target(ElementType.TYPE_PARAMETER)
@interface	What{
	String	description();
}

@Target(ElementType.FIELD)
@interface	EmptyOK{
	
}

@Target(ElementType.METHOD)
@interface	Recommend{
	
}

public class TypeAnnoDemo<@What	(description="Generic data type")	T> {
	public	@Unique	TypeAnnoDemo(){}
	@TypeAnno	String	str;
	@EmptyOK	String	test;
	
	public	int	f(@TypeAnno	TypeAnnoDemo<T>	this,int	x) {
		return	10;
	}
	
	public	@TypeAnno	Integer	f2(int	j,int	k) {
		return	j+k;
	}
	
	public	@Recommend	Integer	f3(String	str) {
		return		str.length();
	}
	
	public	void	f4()	throws	@TypeAnno	NullPointerException{
		
	}
	
	String	[]@MaxLen(10)	@NotZeroLen[]	w;
	
	@TypeAnno	Integer[]	i;
	
	public	static	void	myMeth() {
		
		TypeAnnoDemo<@TypeAnno	String>	ob	=	new	TypeAnnoDemo<>();
		try {
			Method	m	=	ob.getClass().getMethod("myMeth");
		}catch(Exception	e) {
			e.printStackTrace();
		}
	}
	
	
}
