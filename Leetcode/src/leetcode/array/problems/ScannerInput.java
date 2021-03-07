/**
 * 
 */
package leetcode.array.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 5, 2021 Time : 12:16:21 PM
 */
public class ScannerInput {
	static Scanner sc = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static int[] get1DArray() {

		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		return arr;
	}

	public static int[][] get2DArray() {

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		return arr;
	}
	
	public static String[][] get2DStringArray() {

		int n = sc.nextInt();
		int m = sc.nextInt();
		String[][] arr = new String[n][m];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextLine();
			}
		}
		return arr;
	}

	public static int[][] getDynamic2D() {

		int n = sc.nextInt();

		int[][] arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			int m = sc.nextInt();
			arr[i] = new int[m];
			if (m == 1) {
				arr[i][0] = sc.nextInt();
			} else {
				for (int j = 0; j < m; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
		}
		return arr;
	}

}
