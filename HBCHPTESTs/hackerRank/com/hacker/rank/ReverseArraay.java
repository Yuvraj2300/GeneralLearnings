package com.hacker.rank;

public class ReverseArraay {
	public static void main(String[] args) {
		int[] arr	=	new int[] {1,4,3,2};
		reverse(arr);
	}

	public static int[] reverse(int[] a) {
		int[] retArr = new int[a.length];
		for (int i = a.length-1; i >= 0; i--) {
			System.out.print(a[i] + " ");
			retArr[(a.length-1)-i] = a[i];
		}
		return retArr;
	}
}
