/**
 * 
 */
package leetcode.array.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 30, 2021 Time : 11:54:15 AM
 */
public class SubArrayWithSumEqualToK {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SubarraySum arraysum = new SubarraySum();
		int arr[] = {1, 4, 20, 3, 10, 5};
		int n = arr.length;
		int sum = 33;
		arraysum.subArraySum(arr, n, sum);
	}

}

class SubarraySum {

	/**
	 * @param arr
	 * @param n
	 * @param sum
	 */
	public void subArraySum(int[] arr, int n, int sum) {
		int curr_sum = arr[0], start = 0, i;

		// Pick a starting point
		for (i = 1; i <= n; i++) {
			// If curr_sum exceeds the sum,
			// then remove the starting elements
			while (curr_sum > sum && start < i - 1) {
				curr_sum = curr_sum - arr[start];
				start++;
			}

			// If curr_sum becomes equal to sum,
			// then return true
			if (curr_sum == sum) {
				int p = i - 1;
				System.out.println("Sum found between indexes " + start + " and " + p);
				return;
			}

			// Add this element to curr_sum
			if (i < n)
				curr_sum = curr_sum + arr[i];
		}

		System.out.println("No subarray found");
	}

}