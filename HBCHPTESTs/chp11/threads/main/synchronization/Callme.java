package threads.main.synchronization;

public class Callme {
	synchronized	public	void	call(String	msg) {
		System.out.print("["+msg);
		try {
			Thread.sleep(1000);
		}catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("]");
	}
}
