/**
 * 
 */
package leetcode.array.problems;

import java.util.Scanner;

/**
 * @author NIPC-43
 *
 *         Date : Jan 3, 2021 Time : 12:48:08 PM
 */
public class MaximumProductOfTwoElementinArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] startTime = new int[n];
		for (int i = 0; i < n; i++) {
			startTime[i] = sc.nextInt();
		}
		int ans = maxProduct(startTime);
		System.out.println(ans);
		sc.close();
	}

	/**
	 * @param startTime
	 * @return
	 */
	private static int maxProduct(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				max = (nums[i] - 1) * (nums[j] - 1) > max ? (nums[i] - 1) * (nums[j] - 1) : max;
			}
		}
		return max;
	}

}
