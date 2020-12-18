package lrn.kara.leet;

import java.util.HashMap;
import java.util.Map;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:
*/

public class ZigZag {

	private static StringBuilder result=new StringBuilder("");

	public static void main(String[] args) {
		convert("PAYPALISHIRING", 3);
	}

	public static String convert(String s, int numRows) {
		int length = s.length();
		HashMap<Integer, StringBuilder> hm = new HashMap<>();
		int counter = 0;

		for (int i = 0; i < length; i++) {
			hm.put(i, new StringBuilder());
		}

		int it = 0;
		boolean flip = true;

		for (int i = 0; i < length; i++) {
			if (flip) {
				if (it < length) {
					hm.get(it).append(s.charAt(i));
					it++;
				}
			} else {
				hm.get(it).append(s.charAt(i));
				it--;
			}

			if (it + 1 == numRows || it == 0) {
				flip = !flip;
			}
		}

		System.out.println(hm.entrySet());
		for (Map.Entry entry : hm.entrySet()) {
			result.append(entry.getValue());
		}
		System.out.println(result);
		return "";
	}

}
