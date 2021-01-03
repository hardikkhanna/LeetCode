/**
 * 
 */
package leetcode.array.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 3, 2021 Time : 12:11:54 PM
 */
public class FlippingAnImage {

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
		indices = flipAndInvertImage(indices);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(indices[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();

	}

	/**
	 * @param indices
	 * @return
	 */
	private static int[][] flipAndInvertImage(int[][] A) {
		int[][] ans = new int[A.length][A[0].length];
		for (int i = 0; i < A.length; i++) {
			int k = 0;
			for (int j = A[0].length - 1; j >= 0; j--) {
				ans[i][k] = A[i][j];
				if (ans[i][k] == 0)
					ans[i][k] = 1;
				else
					ans[i][k] = 0;
				k++;
			}
		}
		return ans;
	}

}
