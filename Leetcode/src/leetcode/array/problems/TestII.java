/**
 * 
 */
package leetcode.array.problems;

import java.util.Arrays;

/**
 * @author Hardik
 *
 *         Date : 15-May-2021 Time : 1:03:04 pm
 */
public class TestII extends ScannerInput {

	/**
	 * @param args Given a 2 D matrix m*n. find the cost of minimum path to travel
	 *             from top left corner of matrix to bottom right corner. Allowed
	 *             moves are only right and bottom.
	 * 
	 *             0,0 -> 1 2 3 
	 *             		  2 1 1 
	 *             		  5 7 1
	 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = get2DArray();

		int min = minCost(arr, arr.length, arr[0].length);
		System.out.println(min);
		// int[] arr = { 1, 2, 3, 4, 5};

	}

	/**
	 * @param arr
	 * @param length2
	 * @param length
	 * @return
	 */
	private static int minCost(int[][] arr, int row, int col) {

		int[][] cache = new int[row + 1][col + 1];
		Arrays.fill(cache, Integer.MAX_VALUE);
		return minCostHelper(arr, row, col, cache);
		// return [[row][col];
	}

	/**
	 * @param arr
	 * @param row
	 * @param col
	 * @param cache
	 */
	private static int minCostHelper(int[][] arr, int row, int col, int[][] cache) {

		// Check for base cases
		if (row >= arr.length || col >= arr[row].length) {

		}

		if (cache[row][col] != Integer.MAX_VALUE) {
			return cache[row][col];
		}

		cache[row][col] = Math.min(minCostHelper(arr, row + 1, col, cache), minCostHelper(arr, row, col + 1, cache));
		return cache[row][col];

	}

}
