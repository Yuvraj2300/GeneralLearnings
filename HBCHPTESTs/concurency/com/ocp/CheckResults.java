package com.ocp;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CheckResults {
	private static int counter = 0;

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		/*
		 * new Thread(() -> { for (int i = 0; i < 500; i++) { CheckResults.counter++;
		 * System.out.println(counter); } }).start();
		 */
		ExecutorService es = null;

		es = Executors.newSingleThreadExecutor();
		Future<?> future = es.submit(() -> {
			for (int i = 0; i < 500; i++)
				System.out.println("val: " + i);
			CheckResults.counter++;
		});

		try {
			future.get(10, TimeUnit.SECONDS);
			System.out.println("Done");
		} catch (ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (es != null) {
				es.shutdown();
			}
		}

		/*
		 * while (CheckResults.counter < 100) {
		 * System.out.println("Not Reached YeT, counter: " + CheckResults.counter);
		 * Thread.sleep(1000); } System.out.println("Reached!");
		 */
	}
}
