package com.learn.logics;

public class InsertionArray {
	public static void main(String[] args) {
		int[] arr = new int[8];

		for (int i = 0; i < 5; i++) {
			arr[i]	=	i;
		}

		int pos = 3;
		int val = 58;
		insert(arr, pos, val);
	}

	public static void insert(int[] arr, int pos, int value) {
		int arrayLt = arr.length - 1;

		for (int i = arrayLt; i > pos; i--) {
			arr[i + 1] = arr[i];
		}

		arr[pos] = value;

		for (int i = 0; i < arr.length; i++) {
			System.out.print(i);
		}
	}

}
