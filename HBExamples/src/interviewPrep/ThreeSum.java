package interviewPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ThreeSum {

	public static void main(String[] args) {
		int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
		threeSum(nums);
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		int length = nums.length;
		Arrays.sort(nums);
		List<Integer> list;
		List<List<Integer>> wrapperList = new ArrayList<>();

		for (int i = 0; i < length; i++) {
			int l = i + 1;
			int r = length - 1;
//
//			list = new ArrayList<>();

			while (l < r) {
				if (nums[i] + nums[l] + nums[r] == 0) {
					list = new ArrayList<>();
					list.add(nums[l]);
					list.add(nums[i]);
					list.add(nums[r]);
					wrapperList.add(list);
					l++;
					r--;
				} else if (nums[i] + nums[l] + nums[r] < 0) {
					l++;
				} else {
					r--;
				}
			}

		}

		return wrapperList;
	}
}