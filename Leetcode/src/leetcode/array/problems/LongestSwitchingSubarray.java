/**
 * 
 */
package leetcode.array.problems;

/**
 * @author Hardik
 *
 *         Date : 19-May-2021 Time : 9:58:14 pm
 */
public class LongestSwitchingSubarray extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = get1DArray();
		int ans = switchingSubArray(arr);
		System.out.println(ans);
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int switchingSubArray(int[] arr) {
		if (arr == null || arr.length <= 1)
			return 1;
		int max = 2;

		int i = 0;
		int start = 0;
		while (i < arr.length - 1) {
			if ((i + 2 < arr.length && arr[i] == arr[i + 2]) || i + 2 >= arr.length)
				i++;
			else {
				max = Math.max(max, i - start);
				start = i;
				i++;
			}

		}
		if (start == 0)
			max = Math.max(max, i - start + 1);
		else
			max = Math.max(max, i - start);
		return max;
	}

}
