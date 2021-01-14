/**
 * 
 */
package leetcode.array.problems;

import java.util.Arrays;

/**
 * @author NIPC-43
 *
 *         Date : Jan 14, 2021 Time : 4:43:18 PM
 */
public class CanMakeAPFromSequence extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = get1DArray();
		Boolean ans = canMakeArithmeticProgression(arr);
		System.out.println(ans);

	}

	public static boolean canMakeArithmeticProgression(int[] arr) {
		Arrays.sort(arr);
		int diff = arr[1] - arr[0];
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i + 1] - arr[i] != diff) {
				return false;
			}
		}
		return true;
	}

}
