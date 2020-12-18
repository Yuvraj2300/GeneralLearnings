package interviewPrep;

public class GreatestSum {
	public static void main(String[] args) {
		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
	}

	static int maxSubArraySum(int a[]) {
		int length=a.length;
		int max_sum_tracker	=	0;
		int min_sum_till_now	=	0;
		int counter=0;
		
		for(int i=0;i<length;i++) {
//			if(a[i]>0) {
				max_sum_tracker	=	max_sum_tracker+a[i];
				if(min_sum_till_now<max_sum_tracker) {
					min_sum_till_now=max_sum_tracker;
					
				}
//			}
				if(max_sum_tracker<0) {
					max_sum_tracker=0;
					counter++;
				}
		}
		System.out.println(length-counter-1);
		return min_sum_till_now;
	}
}
