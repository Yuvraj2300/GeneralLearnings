package pakcage_32;

public interface IntSt2 extends IntSt {
	default void remove() {
		System.out.println("UPLO");
		try {
			throw new UnsupportedException("NOT SUPP");
		} catch (UnsupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
}
