package lrn.collection.comparator;

import java.util.TreeSet;

public class Comp_2 {
	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<>((a, b) -> b.compareTo(a));
		ts.add("A");
		ts.add("B");
		ts.add("C");
		ts.add("D");

		ts.forEach(s -> System.out.println(s));
	}
}
