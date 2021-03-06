/**
 * 
 */
package leetcode.dp.problems.easy;

import java.util.Arrays;

import leetcode.array.problems.ScannerInput;

/**
 * @author NIPC-57
 *
 *         Date : 09-Jun-2021 Time : 4:39:32 pm
 */
public class JumpGameVI extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] nums = get1DArray();
		int k = sc.nextInt();
		int ans = maxResult(nums, k);
		System.out.println(ans);

	}

	/**
	 * @param nums
	 * @param k
	 * @return
	 */
	static int[] dp;
	private static int maxResult(int[] nums, int k) {
		dp = new int[nums.length];
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[nums.length - 1] = nums[nums.length - 1];
		return maxResult(nums, k, 0, nums.length);
	}

	private static int maxResult(int[] nums, int k, int i, int n) {
		if(dp[i] != Integer.MIN_VALUE) return dp[i];   // already calculated result for index i
	    for(int j = 1; j <= k; j++)       // try jumps of all length and choose the one which maximises the score
		    if(i + j < nums.length)
			    dp[i] = Math.max(dp[i], nums[i] + maxResult(nums, k, i + j, n));
	    return dp[i];
	}
}
