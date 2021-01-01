package leetcode.array.problems;

import java.util.Scanner;

public class RunningSum1DArray {

	public static int[] runningSum(int[] nums) {
		/*
		 * IntStream.range(1, nums.length).forEach(i -> { nums[i] = nums[i] + nums[i -
		 * 1]; });
		 */
		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i] + nums[i - 1];
		}
		return nums;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		array = runningSum(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		sc.close();
	}

}
