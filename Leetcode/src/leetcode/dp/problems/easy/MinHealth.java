/**
 * 
 */
package leetcode.dp.problems.easy;

import leetcode.array.problems.ScannerInput;

/**
 * @author NIPC-57
 *
 *         Date : 08-Jun-2021 Time : 7:51:49 pm
 */
public class MinHealth extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[][] arr = get2DArray();
		int minHealth = minHealthRec(arr);
		System.out.println("Recusrive approach : " + minHealth);

		minHealth = minHealthTabular(arr);
		System.out.println("Tabular : " + minHealth);

	}

	/**
	 * @param arr
	 * @return
	 */
	private static int minHealthTabular(int[][] arr) {
		// TODO Auto-generated method stub
		int[][] dp = new int[arr.length][arr[0].length];
		int m = arr.length;
		int n = arr[0].length;
		for (int i = m - 2; i >= 0; i--) {
			dp[i][n - 1] = arr[i][n - 1] - dp[i + 1][n - 1];
			if (dp[i][n - 1] < 1)
				dp[i][n - 1] = 1;
		}
		for (int i = n - 2; i >= 0; i--) {
			dp[m - 1][i] = arr[m - 1][i] - dp[m - 1][i + 1];
			if (dp[m - 1][i] < 0)
				dp[i][n - 1] = 1;
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				int val =  Math.min(dp[i + 1][j] - arr[i + 1][j], dp[i][j + 1] - arr[i][j + 1]);
				dp[i][j] = val < 1 ? 1 : val;
			}
		}
		return dp[0][0];
	}

	/**
	 * @param arr
	 * @param length
	 * @param length2
	 * @return
	 */
	private static int minHealthRec(int[][] grid) {
		return getMin(grid, 0, 0, grid.length - 1, grid[0].length - 1);
	}

	private static int getMin(int[][] grid, int si, int sj, int ei, int ej) {
		if ((si == ei && sj == ej - 1) || (si == ei - 1 && sj == ej)) {
			return 1;
		}
		if (si > ei || sj > ej) {
			return 0;
		}

		int opt1 = getMin(grid, si + 1, sj, ei, ej);
		if (si + 1 <= ei)
			opt1 -= grid[si + 1][sj];
		int opt2 = getMin(grid, si, sj + 1, ei, ej);
		if (sj + 1 <= ej)
			opt2 -= grid[si][sj + 1];
		if (opt1 < 1)
			opt1 = 1;
		if (opt2 < 1)
			opt2 = 1;
		return Math.min(opt1, opt2);
	}

}