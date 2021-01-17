package pakcage_32;

public interface IntSt {
	void funct1();

	default void remove() throws UnsupportedException {
		throw new UnsupportedException("Not Supported for this class");
	}
}
