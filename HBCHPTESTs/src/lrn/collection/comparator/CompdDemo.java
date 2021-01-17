package lrn.collection.comparator;

import java.util.Comparator;
import java.util.TreeSet;

public class CompdDemo {
	
	public static void main(String[] args) {
		int i=2/0;
		
		MyComp_1 comp	=	new MyComp_1();
		
		TreeSet<String> ts = new TreeSet<>(new MyComp());
		TreeSet<String> ts_1 = new TreeSet<>(comp.reversed());

		
		
		ts_1.add("A");
		ts_1.add("B");
		ts_1.add("C");
		ts_1.add("D");

		ts.add("A");
		ts.add("B");
		ts.add("C");
		ts.add("D");
		
		System.out.println("Op from normal TS");
		ts_1.forEach(s->System.out.println(s));
		
		System.out.println("Op from comparator TS");
		ts.forEach(s->System.out.println(s));
	}
}


class MyComp_1 implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.compareTo(o2);
	}

}

class MyComp implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o2.compareTo(o1);
	}

}
