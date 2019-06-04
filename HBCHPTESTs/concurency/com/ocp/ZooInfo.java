package com.ocp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ZooInfo {
	public static void main(String... args) {
		ExecutorService service = null;

		try {
			service = Executors.newSingleThreadExecutor();
			System.out.println("begin");
			service.execute(() -> {
				System.out.println("Starting the executor");
			});
			service.execute(() -> {
				for (int i = 0; i < 50; i++)
					System.out.println(i);
			});
			service.execute(() -> {
				System.out.println("Last executor");
			});
			System.out.println("End");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (service != null) {
				service.shutdown();
			}
		}
	}
}
