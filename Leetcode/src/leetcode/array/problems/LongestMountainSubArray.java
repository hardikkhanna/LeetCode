/**
 * 
 */
package leetcode.array.problems;

/**
 * @author Hardik
 *
 *         Date : 18-May-2021 Time : 3:38:23 pm
 */
public class LongestMountainSubArray extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = get1DArray();
		int ans = longestMountain(arr, arr.length);
		System.out.println(ans);

	}

	/**
	 * @param arr
	 * @param length
	 * @return
	 */
	private static int longestMountain(int[] arr, int n) {
		if (arr == null || n == 0)
			return 0;

		int ans = 0;
		for (int i = 0; i < arr.length;) {
			int max = arr[i];
			int start = i;
			int peek = 0;
			if (i + 1 < arr.length && arr[i] < arr[i + 1]) {
				// Loop till the mountains peek
				while (++i < arr.length && arr[i] > max) {
					max = arr[i];
				}
				peek = i;
				// Loop till mountains bottom right slope
				while (i < arr.length) {
					if (arr[i] > max)
						break;
					else if (arr[i] > arr[start])
						break;
					max = arr[i];
					i++;
				}
			} else
				i++;
			if (peek != i)
				ans = Math.max(ans, i - start);
		}

		return ans < 3 ? 0 : ans;
	}

}
