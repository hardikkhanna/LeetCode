/**
 * 
 */
package leetcode.array.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 3, 2021 Time : 11:57:43 AM
 */
public class MatrixDiagonalSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int[][] indices = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				indices[i][j] = sc.nextInt();
			}
		}
		int ans = diagonalSum(indices);
		System.out.println(ans);
		sc.close();

	}

	/**
	 * @param indices
	 * @return
	 */
	private static int diagonalSum(int[][] mat) {
		int corners = 0;
		for (int i = 0; i < mat.length; i++) {
			corners += mat[i][i];
		}
		int j = 0;
		for (int i = mat.length - 1; i >= 0; i--) {
			corners += mat[i][j++];
		}
		if (mat.length % 2 != 0)
			return corners - mat[mat.length / 2][mat.length / 2];
		return corners;
	}

}
