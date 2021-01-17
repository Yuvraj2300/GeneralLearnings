package pakcage_32;

public class MethArg {

	public static String stringOp(StringMani sm, String s) {
		return sm.funct(s);
	}

	public static void main(String[] args) {
		String reverseStr = stringOp((s) -> {
			StringBuilder sb = new StringBuilder(s);
			sb.reverse();
			return sb.toString();
		}, "Yuvraj");

		String toUpper = stringOp((s) -> {
			return s.toUpperCase();
		}, "yolo");

		System.out.println(reverseStr);
		System.out.println(toUpper);

	}

}

interface StringMani {
	String funct(String s);
}