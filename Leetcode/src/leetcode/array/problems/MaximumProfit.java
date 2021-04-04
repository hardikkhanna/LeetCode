/**
 * 
 */
package leetcode.array.problems;

import java.util.Arrays;

/**
 * @author Hardik
 *
 *         Date : Mar 19, 2021 Time : 5:32:18 PM
 */
public class MaximumProfit extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = get1DArray();
		int profit = maximumProfit(arr);
		System.out.println(profit);
	}

	public static int maximumProfit(int budget[]) {
		if (budget.length == 0)
			return 0;
		Arrays.sort(budget);

		int index = budget.length / 2;

		int count = 0;
		for (int i = 0; i < budget.length; i++) {
			if (budget[i] >= budget[index]) {
				count++;
			}
		}

		return count * budget[index];
	}

}
