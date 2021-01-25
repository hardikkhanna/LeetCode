/**
 * 
 */
package leetcode.array.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 24, 2021 Time : 8:33:22 PM
 */
public class CountSquareSumatrices extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] A = get2DArray();
		int ans = countSquares(A);
		System.out.println(ans);

	}

	/**
	 * @param a
	 * @return
	 */
	private static int countSquares(int[][] A) {
		int res = 0;
		for (int i = 0; i < A.length; ++i) {
			for (int j = 0; j < A[0].length; ++j) {
				if (A[i][j] > 0 && i > 0 && j > 0) {
					A[i][j] = Math.min(A[i - 1][j - 1], Math.min(A[i - 1][j], A[i][j - 1])) + 1;
				}
				res += A[i][j];
			}
		}
		return res;
	}

}
