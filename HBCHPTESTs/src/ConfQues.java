
public class ConfQues {
	public static void test(String s) {
		System.out.println("In String");
	}

	/*public static void test(Integer s) {
		System.out.println("In Integer");
	}
	*/
	
	public static void test(Object o) {
		System.out.println("In object");
	}

	public static int meth() {
		try {
			int i = 0;
			int j = 2;
			int k = 2 / 0;
			return 1;
		} catch (Exception e) {
			return 2;
		} finally {
			return 3;
		}
	}
	
	 public static int meth_1() {
		try {
			int i = 1;
			int j = 2;
			int k = 2 / 1;
			return 1;
		} catch (Exception e) {
			return 2;
		} finally {
			return 3;
		}
	}

	public static void main(String[] args) {
		
		ConfQues.test(null);
		System.out.println(ConfQues.meth());
		System.out.println(ConfQues.meth_1());

	}

}
