/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.util.ArrayList;
import java.util.Collections;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : 09-May-2021 Time : 8:19:14 am
 */
public class WeeklyCOntest extends ScannerInput {

	public static void main(String[] args) {
		int[][] logs = get2DArray();
		int ans = maximumPopulation(logs);
		System.out.println(ans);

		// Q2.
//		int[] nums1 = get1DArray();
//		int[] nums2 = get1DArray();
//		int maxDistance = maxDistance(nums1, nums2);
//		System.out.println(maxDistance);

//		int[] nums = get1DArray();
//		int ans = maxSumMinProduct(nums);
//		System.out.println(ans);

	}

	/**
	 * @param nums
	 * @return
	 */
	private static int maxSumMinProduct(int[] nums) {

		// check for base cases
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > sum) {
				sum = nums[i];
			} else {
				sum += nums[i];
			}
			max = Math.max(max, (nums[i] + sum) * nums[i]);

		}
		return (max) % 100000007;
	}

	/**
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	private static int maxDistance(int[] nums1, int[] nums2) {
		int max = 0;
		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (i <= j && nums1[i] <= nums2[j]) {
				max = Math.max(j - i, j);
				j++;
			} else if (i < j && nums1[i] > nums2[j]) {
				i++;
			} else {
				i++;
				j++;
			}
		}
		return max;
	}

	/**
	 * @param logs
	 * @return
	 */
	private static int maximumPopulation(int[][] logs) {
		ArrayList<Pair> list = new ArrayList<>();
		for (int[] log : logs) {
			list.add(new Pair(log[0], 1));
			list.add(new Pair(log[1], -1));
		}
		Collections.sort(list, (a, b) -> (a.year == b.year ? a.birth - b.birth : a.year - b.year));
		int max = 0;
		int year = 0;
		int count = 0;
		for (Pair p : list) {
			if (p.birth == 1) {
				count++;
			} else {
				count--;
			}
			if (count > max) {
				max = count;
				year = p.year;
			}
		}
		return year;
	}
}

class Pair {
	public int year;
	public int birth;

	public Pair(int year, int birth) {
		this.year = year;
		this.birth = birth;
	}
}
