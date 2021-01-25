/**
 * 
 */
package leetcode.sort.problems;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : Jan 23, 2021 Time : 8:14:39 PM
 */
public class FindTheHighestAltitude extends ScannerInput {

	public static void main(String[] args) {
		int[] gain = get1DArray();
		int ans = largestAlitude(gain);
		System.out.println(ans);
	}

	/**
	 * @param gain
	 * @return
	 */
	private static int largestAlitude(int[] gain) {
		if (gain.length == 0)
			return 0;
		int max = gain[0] < 0 ? 0 - gain[0] : 0;
		int start = gain[0] < 0 ? 0 : gain[0];
		int ans = 0;
		for (int i = 0; i < gain.length; i++) {
			if (gain[i] < 0) {
				start = gain[i];
				continue;
			} else if (max < (gain[i] - Math.abs(start))) {
				max = (gain[i] - Math.abs(start));
				ans = gain[i];
			}
			start = gain[i];
		}
		return ans;
	}

}
