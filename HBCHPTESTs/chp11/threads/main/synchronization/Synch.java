package threads.main.synchronization;

public class Synch {
	synchronized	public static void main(String[] args) {
		Callme	target	=	new	Callme();
		Caller	ob1	=	new	Caller(target, "Hello");
		Caller	ob2	=	new	Caller(target, "Hey");
		Caller	ob3	=	new	Caller(target, "What's Up!");
		
		try {
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
		}catch(InterruptedException	e) {
			e.getMessage();
		}
		
	}
}
