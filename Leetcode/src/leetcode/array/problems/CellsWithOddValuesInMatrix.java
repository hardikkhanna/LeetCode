/**
 * 
 */
package leetcode.array.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 2, 2021 Time : 8:20:18 PM
 */
public class CellsWithOddValuesInMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int row = sc.nextInt();
		int col = sc.nextInt();
		int[][] indices = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				indices[i][j] = sc.nextInt();
			}
		}
		int ans = oddCells(indices, n, m);
		System.out.println(ans);
		sc.close();

	}

	/**
	 * @param arr
	 * @param m
	 * @param num
	 * @return
	 */
	private static int oddCells(int[][] indices, int n, int m) {
		int[][] arr = new int[n][m];
		long oddCount = 0;
		for (int i = 0; i < indices.length; i++) {
			int row = indices[i][0];
			int col = indices[i][1];
			for (int j = 0; j < arr.length; j++) {
				arr[j][col]++;
			}
			for (int k = 0; k < arr[row].length; k++) {
				arr[row][k]++;
			}

		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] % 2 != 0) {
					oddCount++;
				}
			}
		}
		return (int) oddCount;
	}

}
