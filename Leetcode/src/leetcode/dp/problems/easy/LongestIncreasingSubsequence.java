/**
 * 
 */
package leetcode.dp.problems.easy;

import java.util.Arrays;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : Feb 19, 2021 Time : 2:34:58 PM
 */
public class LongestIncreasingSubsequence extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = get1DArray();
		// approach 1 time complexity is O(n2)
		int length = getLISapproach1(arr);
		System.out.println("Longest Increasing Subssequence from Approach 1 : " + length);
		// approach 2 time complexity is O(nlogn)
		length = getLISapproach2(arr);
		System.out.println("Longest Increasing Subssequence from Approach 2 : " + length);
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int getLISapproach2(int[] arr) {
		if (arr.length == 0)
			return 0;

		int[] lis = new int[arr.length];

		int ans = 0, lo = 0, hi = 0;
		for (int i = 0; i < arr.length; i++) {
			lo = 0;
			hi = ans;
			while (lo < hi) {
				int mid = lo + (hi - lo) / 2;

				if (lis[mid] < arr[i]) {
					lo = mid + 1;
				} else {
					hi = mid;
				}
			}
			lis[lo] = arr[i];
			if (lo == ans) {
				ans++;
			}

		}

		return ans;

	}

	/**
	 * @param arr
	 * @return
	 */
	private static int getLISapproach1(int[] arr) {
		if (arr.length == 1) {
			return 1;
		}
		int[] lis = new int[arr.length];
		Arrays.fill(lis, 1);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
			}
		}
		Arrays.sort(lis);
		return lis[lis.length - 1];
	}

}
