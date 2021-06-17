/**
 * 
 */
package leetcode.array.problems;

/**
 * @author Hardik
 *
 *         Date : 01-May-2021 Time : 7:34:03 pm
 */
public class MaximumSumRectangle extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] arr = get2DArray();
		int maxRectangleSum = getMaxSum(arr, arr.length, arr[0].length);
		System.err.println(maxRectangleSum);

	}

	/**
	 * @param arr
	 * @param row
	 * @param col
	 * @return
	 */
	private static int getMaxSum(int[][] arr, int n, int m) {
		// check for base cases
		if (arr == null || arr.length == 0)
			return 0;

		int maxSum = Integer.MIN_VALUE;

		for (int left = 0; left < m; left++) {
			int temp[] = new int[n];

			for (int right = left; right < m; right++) {
				for (int i = 0; i < n; i++) {
					temp[i] += arr[i][right];
				}

				int sum = kadaneAlgo(temp, n);

				maxSum = Math.max(maxSum, sum);
			}
		}

		return maxSum;
	}

	/**
	 * @param arr
	 * @param row
	 * @return
	 */
	private static int kadaneAlgo(int[] arr, int row) {
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;

		for (int currIndex = 0; currIndex < row; currIndex++) {
			sum += arr[currIndex];

			if (maxSum < sum) {
				maxSum = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
		}

		return maxSum;
	}

}
