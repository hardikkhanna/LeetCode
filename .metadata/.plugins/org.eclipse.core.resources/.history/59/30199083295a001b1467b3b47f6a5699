/**
 * 
 */
package leetcode.array.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 1, 2021 Time : 10:16:31 PM
 */
public class SumOfAllOddLengthSubArrays {

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
		int ans = sumOddLengthSubarrays(arr);
		System.out.println(ans);
		sc.close();

	}

	/**
	 * @param arr
	 * @return
	 */
	private static int sumOddLengthSubarrays(int[] arr) {
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result += arr[i] * (i + 1) * (arr.length - i);
		}
		return result;
	}

}
