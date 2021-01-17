package pakcage_32;

public class DoSome {
	public static void main(String[] args) {
		MyNum num = () -> {
			return (int) (Math.random()*100);
		};
		System.out.println(num.doSome());
	}

}
