package threads.main;

public class ThreadDemo {

	public static void main(String[] args) {
		Thread t = new Thread().currentThread();
		System.out.println("Information of current thread: " + t);

		t.setName("My Main Thread");
		System.out.println("Changed Information of current thread: " + t);

		for (int i = 5; i >= 0; i--) {
			try {
				System.out.println(i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
