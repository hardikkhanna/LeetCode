/**
 * 
 */
package leetcode.interview.questions.easy;

import leetcode.array.problems.ScannerInput;

/**
 * @author NIPC-43
 *
 *         Date : Mar 8, 2021 Time : 4:53:48 PM
 */

/*
 * Given a sorted array nums, remove the duplicates in-place such that each
 * element appears only once and returns the new length.
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * Clarification:
 * 
 * Confused why the returned value is an integer but your answer is an array?
 * 
 * Note that the input array is passed in by reference, which means a
 * modification to the input array will be known to the caller as well.
 * 
 * Internally you can think of this:
 */
public class RemoveDuplicatesFromSortedArray extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = get1DArray();
		int length = removeDuplicates(nums);
		for (int i = 0; i < length; i++) {
			System.out.println(nums[i]);
		}

	}

	/**
	 * @param nums
	 * @return
	 */
	private static int removeDuplicates(int[] nums) {
		int j = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[j] = nums[i];
				j++;
			}
		}
		return j;
	}

}
