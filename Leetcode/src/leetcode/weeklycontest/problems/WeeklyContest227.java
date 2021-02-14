/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : Feb 7, 2021 Time : 8:02:50 AM
 */
public class WeeklyContest227 extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// checkIfArrayisSortedAndRotated();
		closestSubsequenceSum();
	}

	/**
	 * 
	 */
	private static void closestSubsequenceSum() {
		int[] nums = get1DArray();
		Scanner sc = new Scanner(System.in);
		int goal = sc.nextInt();
		int ans = minAbsDifference(nums, goal);
		System.out.println(ans);

	}

	/**
	 * @param nums
	 * @param goal
	 * @return
	 */
	private static int minAbsDifference(int[] nums, int goal) {
		int min = Integer.MAX_VALUE;

		Arrays.sort(nums);
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum += nums[i];
			if (Math.abs(sum - goal) < min) {
				min = Math.abs(sum - goal);
			}
			if (sum == goal) {
				return 0;
			}
		}

		int backMin = Integer.MAX_VALUE;
		sum = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			sum += nums[i];
			if (Math.abs(sum - goal) < backMin) {
				backMin = Math.abs(sum - goal);
			}
			if (sum == goal) {
				return 0;
			}
		}
		if (min > Math.abs(goal) && backMin > Math.abs(goal)) {
			return Math.abs(goal);
		}
		return Math.min(min, backMin);
	}

	/**
	 * 
	 */
	private static void checkIfArrayisSortedAndRotated() {
		int[] nums = get1DArray();
		Boolean ans = helper(nums);
		System.out.println(ans);

	}

	/**
	 * @param nums
	 * @return
	 */
	private static Boolean helper(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
			list2.add(nums[i]);
		}
		list2 = list2.stream().sorted().collect(Collectors.toList());
		if (list.equals(list2))
			return true;
		for (int i = 0; i < nums.length; i++) {
			int val = list.get(0);
			list.remove(0);
			list.add(list.size(), val);
			if (list.equals(list2)) {
				return true;
			}
		}
		return false;
	}

}
