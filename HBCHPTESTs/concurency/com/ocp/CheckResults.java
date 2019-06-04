package com.ocp;

public class CheckResults {
	private static int counter = 0;

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		new Thread(() -> {
			for (int i = 0; i < 500; i++) {
				CheckResults.counter++;
				System.out.println(counter);
			}
		}).start();
		while(CheckResults.counter<100) {
			System.out.println("Not Reached YeT, counter: "+CheckResults.counter);
			Thread.sleep(1000);
		}
		System.out.println("Reached!");
	}

}
