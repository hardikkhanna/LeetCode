/**
 * 
 */
package leetcode.dp.problems.easy;

import java.util.Arrays;

import leetcode.array.problems.ScannerInput;

/**
 * @author NIPC-43
 *
 *         Date : Feb 21, 2021 Time : 4:02:27 PM
 */
public class CountAllIncreasingSubsequence extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = get1DArray();
		// Approach 1: O(n2)
		int count = countIncreasingSubsequence(arr);
		System.out.println(count);

	}

	/**
	 * @param arr
	 * @return
	 */
	private static int countIncreasingSubsequence(int[] arr) {
		int[] dp = new int[arr.length];
		Arrays.fill(dp, 1);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] += dp[j];
				}
			}
		}
		return Arrays.stream(dp).sum();
	}

}
