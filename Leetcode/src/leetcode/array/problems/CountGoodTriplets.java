/**
 * 
 */
package leetcode.array.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 2, 2021 Time : 8:16:42 AM
 */
public class CountGoodTriplets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int ans = countGoodTriplets(arr, a, b, c);
		System.out.println(ans);
		sc.close();

	}

	/**
	 * @param arr
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private static int countGoodTriplets(int[] arr, int a, int b, int c) {
		int count = 0;
		int n = arr.length;
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				if (Math.abs(arr[i] - arr[j]) <= a) { // check if satisfy then loop for k
					for (int k = j + 1; k < n; k++) {
						if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[k] - arr[i]) <= c)
							count++;
					}
				}
			}
		}

		return count;
	}

}
