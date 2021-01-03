/**
 * 
 */
package leetcode.array.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 2, 2021 Time : 7:22:57 PM
 */
public class MinimumTimeToVisitAllPoints {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int ans = minTimeToVisitAllPoints(arr);
		System.out.println(ans);
		sc.close();

	}

	/**
	 * @param arr
	 * @return
	 */
	private static int minTimeToVisitAllPoints(int[][] arr) {
		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			count += Math.max(Math.abs(arr[i][0] - arr[i + 1][0]), Math.abs(arr[i][1] - arr[i + 1][1]));
		}
		return count;
	}

}
