package lrn.kara.recursion;

public class SortingArray {
	public static void main(String[] args) {
		int[] arr = new int[] { 65, 56, 1, 2 };
		System.out.println(isArraySorted(arr, arr.length));
	}

	public static boolean isArraySorted(int[] arr, int maxIndex) {
		if (arr.length == 1) {
			return true;
		} else {
		//	return (arr[maxIndex - 1] < arr[maxIndex - 2]) ? 0 : isArraySorted(arr, maxIndex - 1);
			if(arr[maxIndex - 1] < arr[maxIndex - 2]) {
				return false;
			}
			return isArraySorted(arr, maxIndex-1);
		}
	}

}
