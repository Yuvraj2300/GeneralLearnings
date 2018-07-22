package com.learn.Iteratorz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {
	public static void main(String[] args) {
		List<String> al = new ArrayList<>();

		al.add("Yuvraj");
		al.add("Rahul");
		al.add("Suman");
		al.add("Nitin");
		al.add("Rajesh");
		al.add("Jack");
		al.add("Kerouck");

		Iterator<String> itr = al.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		ListIterator<String>	listItr	=	al.listIterator();
		
		while(listItr.hasNext()) {
		String	ele	=	listItr.next();
			listItr.set(ele	+	"++");
		}
	}
}
