/**
 * 
 */
package leetcode.array.problems;

import java.util.Arrays;

/**
 * @author Hardik
 *
 *         Date : Jan 14, 2021 Time : 8:01:50 AM
 */
public class ArrayPartitionI extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = get1DArray();
		int ans = arrayPairSum(arr);
		System.out.println(ans);

	}

	private static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int ans = 0;
		for (int i = 0; i < nums.length; i += 2) {
			ans += Math.min(nums[i], nums[i + 1]);
		}
		return ans;
	}

}
