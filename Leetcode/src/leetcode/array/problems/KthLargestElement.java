/**
 * 
 */
package leetcode.array.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Hardik
 *
 *         Date : 03-May-2021 Time : 10:34:40 am
 */
public class KthLargestElement extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = get1DArray();
		int k = 3;
		// Approach 1 :
		// Time Complexity : O(nlogn)
		// Space COmplexity : O(1)
		//int ans = kthLargest(nums, k);
		//System.out.println(ans);

		// Approach 2
		// Time Complexity : O(n)
		// Space Complexity : O(n)
		int ans = kthLargestII(nums, k);
		System.out.println(ans);
	}

	/**
	 * @param nums
	 * @param k
	 * @return
	 */
	private static int kthLargestII(int[] nums, int k) {
		// check for base cases
		if (nums == null || nums.length == 0 || k > nums.length)
			return 0;
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int element : nums) {
			q.add(element);
			if(q.size() > k) {
				q.poll();
			}
		}
		return q.poll();
	}

	/**
	 * @param nums
	 * @param k
	 * @return
	 */
	private static int kthLargest(int[] nums, int k) {
		// check for base cases
		if (nums == null || nums.length == 0 || k > nums.length)
			return 0;

		Arrays.sort(nums);

		return nums[nums.length - k];
	}

}
