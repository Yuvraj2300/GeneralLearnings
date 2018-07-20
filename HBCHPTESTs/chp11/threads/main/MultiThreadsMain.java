package threads.main;

import threads.main.runnable.MultipleThreads;

public class MultiThreadsMain {
	public	static	synchronized	void	main(String[]	args) {
		System.out.println("In the main thread.");
		
		new	MultipleThreads("One");
		new	MultipleThreads("Two");
		new	MultipleThreads("Three");
		
		
		try {
				Thread.sleep(10000);
		}catch(InterruptedException	e) {
			e.getMessage();
		}
		System.out.println("Exiting the main thread");
	}
}
