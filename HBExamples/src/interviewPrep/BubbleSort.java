package interviewPrep;

public class BubbleSort {
	public static void main(String[] args) {

		Integer[] inp = { 34, 65, 3, 1, 443 };
		int temp;
		for (int i = 0; i < inp.length; i++) {
			for (int j =1; j < inp.length-i; j++) {
				if (inp[j] < inp[i]) {
					temp = inp[i];
					inp[i] = inp[j];
					inp[j] = temp;
				}
			}
		}
		for (Integer i : inp) {
			System.out.print(i+" ");
		}
	}
}
