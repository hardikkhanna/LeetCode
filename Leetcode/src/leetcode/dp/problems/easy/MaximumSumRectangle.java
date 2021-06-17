/**
 * 
 */
package leetcode.dp.problems.easy;

import leetcode.array.problems.ScannerInput;

/**
 * @author NIPC-57
 *
 *         Date : 09-Jun-2021 Time : 12:49:35 am
 */
public class MaximumSumRectangle extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[][] arr = get2DArray();
		int maxSum = maxSum(arr, arr.length, arr[0].length	);
		System.out.println("Maximum Sum = " + maxSum);

	}

	/**
	 * @param arr
	 * @param length
	 * @param length2
	 * @return
	 */
	private static int maxSum(int[][] arr, int row, int col) {
		// TODO Auto-generated method stub
		return 0;
	}

}
