package com.learn.logics;

public class Patterns {
	public static void main(String[] args) {
		int[][] twoD = new int[3][2];
		/*
		 * for (int i = 0; i < twoD.length; i++) { for (int j = 0; j < twoD[i].length;
		 * j++) System.out.print(twoD[i][j] + " "); // print element
		 * System.out.println(); // time for a new row }
		 */

		String[][] arrS = { { "*", "*", "*", "*" }, { "*", "*", "*" }, { "*", "*", "*" }, { "*", "*" }, { "*" } };

		for (int i = 0; i < arrS.length; i++) {
			for (int j = i; j < arrS[i].length; j++) {
				System.out.println(arrS[i][j] + " ");
			}
			System.out.println();
		}

	}
}
