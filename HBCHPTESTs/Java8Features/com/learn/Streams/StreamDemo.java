package com.learn.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {
	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<>();
		myList.add(24);
		myList.add(1);
		myList.add(34);
		myList.add(43);
		myList.add(32);
		myList.add(18);
		myList.add(7);

		System.out.println("Original List: " + myList);
		System.out.println();

		Stream<Integer> myStream = myList.stream();

		Optional<Integer> minVal = myStream.min(Integer::compare);
		if (minVal.isPresent())
			System.out.println("The minimum value in list is: " + minVal.get());

		System.out.println();

		myStream = myList.stream();
		Optional<Integer> maxVal = myStream.max(Integer::compare);
		if (maxVal.isPresent())
			System.out.println("Max value is: " + maxVal.get());

		System.out.println();

		Stream<Integer> sortedStream = myList.stream().sorted();
		System.out.println("Sorted Stream:");
		sortedStream.forEach((n) -> System.out.print(n + ", "));
		System.out.println();

		System.out.println();
		Stream<Integer> oddVals = myList.stream().sorted().filter((n) -> (n % 2) == 1);
		System.out.println("Odd Vals: ");
		oddVals.forEach((n) -> System.out.print(n + " "));

	}
}
