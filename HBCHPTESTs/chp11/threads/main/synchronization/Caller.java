package threads.main.synchronization;

public class Caller implements	Runnable{
	public	Thread	t;
	Callme	target;
	String	msg;
	
	public	Caller(Callme	target,String	msg){
		this.target=target;
		this.msg=msg;
		t	=	new	Thread(this);
		t.start();
	}
	
	public	void	run() {
		target.call(msg);
	}
}
