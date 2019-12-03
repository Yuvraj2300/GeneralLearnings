
public class Palin {
	static Integer counter = 0;

	public static boolean checkPalindrome(String value) {

		StringBuilder sb = new StringBuilder(value);

		for (int i = 0; i < value.length(); i++) {
			sb.deleteCharAt(i);

			if (isPalindrome(sb.toString())) {
				counter++;
				return true;
			} else {
				counter++;
				checkReverse(value);
			}

			/*
			 * else { sb.insert(i, value.charAt(i)); }
			 */
		}
		return false;
	}

	private static boolean checkReverse(String value) {
		StringBuilder sb = new StringBuilder(value);
		for (int i = value.length() - 1; i >= 0;) {
			sb.deleteCharAt(i);
			if (isPalindrome(sb.toString())) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	private static boolean isPalindrome(String string) {
		return string.equals(new StringBuilder(string).reverse().toString());
	}

	public static void main(String[] args) {
		System.out.println(checkPalindrome("ABCBXA"));
		System.out.println(checkPalindrome("ABCBAX"));
		System.out.println(checkPalindrome("ABCXBA"));
		System.out.println(checkPalindrome("ABCDE"));
		System.out.println(checkPalindrome("BAAAAC"));

		// TAKE INPUT HERE
	}
}
