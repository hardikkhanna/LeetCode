/**
 * 
 */
package leetcode.array.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Hardik
 *
 *         Date : 05-May-2021 Time : 11:45:32 pm
 */
public class ThreeSum extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = get1DArray();
		List<List<Integer>> sum = threeSum(nums);
		for (List<Integer> list : sum) {
			System.out.println(list);
		}

	}

	/**
	 * @param nums
	 * @return
	 */
	private static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		// check for base cases
		if (nums == null || nums.length == 0)
			return list;

		// Sort the array
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				int sum = 0 - (nums[i] + nums[j]);
				if (search(nums, j + 1, nums.length - 1, sum)) {
					ArrayList<Integer> arr = new ArrayList<Integer>();
					arr.add(nums[i]);
					arr.add(nums[j]);
					arr.add(sum);
					Collections.sort(arr);
					if (!list.contains(arr))
						list.add(arr);
				}
			}
		}
		return list;
	}

	private static boolean search(int[] nums, int start, int end, int target) {
		if (start > end)
			return false;

		int mid = (start + end) / 2;

		if (nums[mid] == target)
			return true;
		if (nums[mid] > target)
			return search(nums, start, mid - 1, target);
		return search(nums, mid + 1, end, target);
	}

}
