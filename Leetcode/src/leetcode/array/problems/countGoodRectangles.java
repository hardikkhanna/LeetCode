/**
 * 
 */
package leetcode.array.problems;

import java.util.Arrays;

/**
 * @author Hardik
 *
 *         Date : Jan 17, 2021 Time : 8:05:29 AM
 */
public class countGoodRectangles extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] arr = get2DArray();
		int ans = countrec(arr);
		System.out.println(ans);

	}

	/**
	 * @param arr
	 * @return
	 */
	private static int countrec(int[][] rectangles) {
		int[] arr = new int[rectangles.length];
		int j = 0;
		for (int i = 0; i < rectangles.length; i++) {
			arr[j++] = Math.min(rectangles[i][0], rectangles[i][1]);
		}
		Arrays.sort(arr);
		j = 1;
		for (int i = arr.length - 1; i >= 1; i--) {
			if (arr[i] != arr[i - 1])
				break;
			j++;
		}
		return j;
	}

}
