package threads.main;

import threads.main.runnable.NewThread;

public class RunnableDemo {
	public	static		void	main(String[]	args) {
		new	NewThread();
	//	NewThread	n	=	new	NewThread();
		//n.run();
		
		try {
			for(int	i=5;i>=0;i--) {
				System.out.println("Main Thread: " + i);
				Thread.sleep(1000);
			}
		}catch(InterruptedException	e) {
			e.getMessage();
		}
		System.out.println("Exiting the Main Thread");
	}
}
