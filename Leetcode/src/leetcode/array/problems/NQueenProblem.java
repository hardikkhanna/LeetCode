/**
 * 
 */
package leetcode.array.problems;

/**
 * @author Hardik
 *
 *         Date : 22-May-2021 Time : 1:03:12 am
 */
public class NQueenProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int row = sc.nextInt();
		int col = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[row][col];
		numberOfWays(arr, 0, 0, n);
	}

	/**
	 * @param arr
	 * @param row
	 * @param col
	 * @param queens
	 */
	private static void numberOfWays(int[][] arr, int row, int col, int queens) {

		if (row == arr.length) {
			printArray(arr);
			return;
		}
		for (int j = 0; j < arr.length; j++) {
			if (isPossible(arr, row, j)) {
				arr[row][j] = 1;
				numberOfWays(arr, row + 1, 0, queens);
				arr[row][j] = 0;
			}
		}
		return;

	}

	/**
	 * @param arr
	 * @param row
	 * @param col
	 * @return
	 */
	private static boolean isPossible(int[][] arr, int row, int col) {

		for (int i = row - 1; i >= 0; i--) {
			if (arr[i][col] == 1)
				return false;
		}

		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (arr[i][j] == 1)
				return false;
		}

		for (int i = row - 1, j = col + 1; i >= 0 && j < arr.length; i--, j++) {
			if (arr[i][j] == 1)
				return false;
		}

		return true;
	}

	/**
	 * @param arr
	 * 
	 */
	private static void printArray(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
		}
		System.out.println();

	}

}
