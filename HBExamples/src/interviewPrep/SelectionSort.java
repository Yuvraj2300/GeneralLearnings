package interviewPrep;

public class SelectionSort {
	public static void main(String[] args) {
		Integer[] inp = { 33, 21, 42, 3, 24 };
		int smallestNum;
		int index;

		for (int i = 0; i < inp.length; i++) {
			index = i;
			for (int j = i + 1; j < inp.length; j++) {
				if (inp[j] < inp[index]) {
					index = j;
				}
			}
			smallestNum = inp[index];
			inp[index]	=	inp[i];
			inp[i] = smallestNum;
		}
		
		for (Integer i : inp) {
			System.out.print(i + " ");
		}
	}
}
