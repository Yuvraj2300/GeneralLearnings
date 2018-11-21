package com.learn.staticL;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DdupExample {
	public static void main(String[] args) {
	//	String val = dDup("Yuvraj 123 123");
		//	18            ~980018
		String	rowid	=	"18            ";
		System.out.println(rowid);
		rowid.trim();
		System.out.println(rowid);
		String	rowIdTrimmed	=	removeWhiteSpaces(rowid);
		System.out.println(rowIdTrimmed);
		String	prowId	=	"980018";
		removeWhiteSpaces(prowId);
		String	psrcKey	=	rowIdTrimmed+"~"+prowId;
		removeWhiteSpaces(psrcKey);
		System.out.println(psrcKey);
	}

	
	public	static	String	removeWhiteSpaces(String	s){
		String	val	=	s.trim();
		return	val;
	}
//	Yuvraj 123 123

	public static String dDup(String s) {
//		replaceAll("(^\\\\[|\\\\]$)", "")
//		return new LinkedHashSet<String>(Arrays.asList(s.split("\\s"))).toString().replaceAll("/[!@#$%^&*]/g","").replace(",", "");
		return Arrays.stream(s.split("\\s")).distinct().collect(Collectors.joining(" "));
	
	}
}
