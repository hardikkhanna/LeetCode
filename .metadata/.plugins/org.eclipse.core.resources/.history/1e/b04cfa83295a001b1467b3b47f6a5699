/**
 * 
 */
package leetcode.array.problems;

import java.util.Arrays;

/**
 * @author Hardik
 *
 *         Date : Jan 14, 2021 Time : 11:44:43 AM
 */
public class MakeTwoArraysEqual extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] target = get1DArray();
		int[] arr = get1DArray();
		Boolean ans = canBeEqual(target, arr);
		System.out.println(ans);
	}

	/**
	 * @param target
	 * @param arr
	 * @return
	 */
	private static Boolean canBeEqual(int[] target, int[] arr) {
		Arrays.sort(target);
		Arrays.sort(arr);
		if (Arrays.equals(target, arr))
			return true;
		return false;
	}

}
