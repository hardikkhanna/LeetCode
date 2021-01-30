/**
 * 
 */
package leetcode.array.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 25, 2021 Time : 2:13:12 PM
 */
public class CheckIfAll1AreKFeatApart extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = get1DArray();
		int k = sc.nextInt();
		Boolean ans = kLengthApart(nums, k);
		System.out.println(ans);
		sc.close();
	}

	/**
	 * @param nums
	 * @param k
	 * @return
	 */
	private static Boolean kLengthApart(int[] nums, int k) {
		int index = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				if (index == -1) {
					index = i;
					continue;
				}
				if (i - index <= k) {
					return false;
				}
				index = i;
			}
		}
		return true;
	}

}
