package com.ocp;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExp {
	public static void main(String args[]) {
		CountDownLatch cd1 = new CountDownLatch(5);
		CountDownLatch cd2 = new CountDownLatch(5);
		CountDownLatch cd3 = new CountDownLatch(5);
		CountDownLatch cd4 = new CountDownLatch(5);
		ExecutorService es = Executors.newFixedThreadPool(2);

		// Start the threads
//		es.execute(new MyThread(cd1, "A"));
//		es.execute(new MyThread(cd2, "B"));
//		es.execute(new MyThread(cd3, "C"));
//		es.execute(new MyThread(cd4, "D"));

		try {
			cd1.await();
			cd2.await();
			cd3.await();
			cd4.await();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//shut down is really important as the thread will always be executing if not called
		es.shutdown();
		System.out.println("Done");
	}
}

class MyThread implements Runnable {
	CountDownLatch latch;
	String val;

	MyThread(CountDownLatch latch, String val) {
		this.latch = latch;
		this.val = val;

		new Thread(this);
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("name : "+i);
			latch.countDown();
		}
	}

}
