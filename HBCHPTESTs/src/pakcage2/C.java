package pakcage2;

public class C extends B {

	public static void main(String[] args) {
		B b = new C();
		b.doSome();
	}

	@Override
	void doSome() {
		// TODO Auto-generated method stub
		System.out.println("Doing SOme in C :)");
	}
}
