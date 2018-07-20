package threads.main.runnable;

public class NewThread implements Runnable {
	Thread t;

	public NewThread() {
		t = new Thread(this, "Child Thread");
		System.out.println("Child Thread: " + t);
		t.start();
	}

	public 	void run() {
		try {
			for (int i = 5; i >= 0; i--) {

				System.out.println("Child Thread: " + i);
				t.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.getMessage();
		}
		System.out.println("Exiting the Child Thread");
	}
}
