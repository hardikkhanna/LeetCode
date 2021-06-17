/**
 * 
 */
package leetcode.array.problems;

import java.util.HashSet;

/**
 * @author Hardik
 *
 *         Date : 28-May-2021 Time : 3:36:49 pm
 */
public class MaximumUniqueSubarray extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = get1DArray();
		int ans = maximumUniqueSubarray(arr);
		System.out.println(ans);
		ans = bruteFroce(arr);
		System.out.println(ans);

	}

	/**
	 * @param arr
	 * @return
	 */
	private static int bruteFroce(int[] nums) {
		int ans = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			HashSet<Integer> set = new HashSet<>();
			set.add(nums[i]);
			int sum = nums[i];
			for (int j = i + 1; j < nums.length; j++) {

				if (set.contains(nums[j])) {
					break;
				}
				sum += nums[j];
				set.add(nums[j]);
			}
			ans = Math.max(ans, sum);
		}
		return ans;
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int maximumUniqueSubarray(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		int start = 0;
		int end = 0;
		int sum = 0;
		int ans = Integer.MIN_VALUE;

		while (end < nums.length) {
			if (set.size() > 0 && set.contains(nums[end])) {
				while (nums[start] != nums[end] && start < end) {
					sum -= nums[start];
					set.remove(nums[start]);
					start++;

				}
				sum -= nums[start];
				set.remove(nums[start]);
				start++;
			}

			set.add(nums[end]);
			sum += nums[end];
			// System.out.print(sum + " ");
			ans = Math.max(ans, sum);
			end++;
		}

		return ans;
	}

}
