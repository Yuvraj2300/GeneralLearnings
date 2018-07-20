package threads.main.runnable;



public class MultipleThreads implements	Runnable{

	String	name;
	Thread	t;
	
	//CREATE A GENERIC CONSTRUCTOR
	public	MultipleThreads(String	name) {
		this.name	=	name;
		t	=	new	Thread(this, name);
		System.out.println("New Thread: "+	t);
		t.start();
		
	}
	
	public	void	run() {
		try {
			for(int	i=5;i>0;i--) {
				System.out.println(t.getName()+": "+i);
				Thread.sleep(500);
			}
		}catch(InterruptedException	e) {
			e.getMessage();
		}
		System.out.println("Exiting the "+t.getName()+" thread");
	}
	
}
