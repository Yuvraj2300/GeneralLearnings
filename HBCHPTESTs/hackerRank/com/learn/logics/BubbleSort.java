package com.learn.logics;

import java.util.Scanner;

import java.util.Scanner;

public class BubbleSort {
	public Scanner sc = new Scanner(System.in);

	public static void sort(Integer[] inp, int length) {
		int temp;

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length - 1; j++) {
				if (inp[j] > inp[j + 1]) {
					temp = inp[j + 1];
					inp[j + 1] = inp[j];
					inp[j] = temp;
				}
			}
		}

	}

	public static void main(String... args) {
		Integer[] inp = { 55, 214, 24, 21, 100 };
		int length = inp.length;
		sort(inp, length);
		for (int i = 0; i < length; i++) {
			System.out.print(inp[i]+" ");
		}
	}
}
