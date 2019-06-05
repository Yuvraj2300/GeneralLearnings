package com.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class DemoSync {

	private AtomicInteger sheep	=	new	AtomicInteger(0);

	public synchronized void countSheeps() {
		System.out.print(sheep.incrementAndGet()+" ");
	}

	public static void main(String[] args) {
		ExecutorService es = null;

		DemoSync manager = new DemoSync();

		try {
			es = Executors.newFixedThreadPool(20);
			es.submit(() -> {

				for (int i = 0; i < 10; i++)
					manager.countSheeps();

			});
		} catch (Exception e) {

		} finally {
			if (es != null) {
				es.shutdown();
			}
		}

	}
}
