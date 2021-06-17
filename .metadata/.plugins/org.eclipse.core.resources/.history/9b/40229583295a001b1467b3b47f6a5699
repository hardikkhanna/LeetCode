/**
 * 
 */
package leetcode.array.problems;

import java.util.Arrays;

/**
 * @author Hardik
 *
 *         Date : Jan 14, 2021 Time : 11:50:54 AM
 */
public class HeightChecker extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = get1DArray();
		int ans = heightChecker(arr);
		System.out.println(ans);

	}

	/**
	 * @param arr
	 * @return
	 */
	private static int heightChecker(int[] heights) {
		int[] arr = heights.clone();
		Arrays.sort(heights);
		int count = 0;
		if (!Arrays.equals(heights, arr)) {
			for (int i = 0; i < heights.length; i++) {
				if (heights[i] != arr[i])
					count++;
			}
		}
		return count;
	}

}
