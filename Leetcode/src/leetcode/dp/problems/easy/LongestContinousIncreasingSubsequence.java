/**
 * 
 */
package leetcode.dp.problems.easy;

import java.util.Arrays;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : Feb 21, 2021 Time : 2:07:23 PM
 */
public class LongestContinousIncreasingSubsequence extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = get1DArray();
		// approach 1 time complexity is O(n2)
		int length = getLISapproach1(arr);
		System.out.println("Longest Increasing Subssequence from Approach 1 : " + length);

		length = getLISapproach2(arr);
		System.out.println("Longest Increasing Subssequence from Approach 2 : " + length);
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int getLISapproach2(int[] nums) {
		if (nums.length == 0)
			return 0;
		int current = 1;
		int max = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				current++;
			} else {
				current = 1;
			}
			if (current > max) {
				max = current;
			}
		}
		return max;
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int getLISapproach1(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length < 2)
			return 1;
		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				dp[i] = Math.max(dp[i], dp[i - 1] + 1);
			}
		}
		Arrays.sort(dp);
		return dp[dp.length - 1];
	}

}
