/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.util.Arrays;
import java.util.Scanner;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : 25-Apr-2021 Time : 8:46:39 am
 */
public class WeeklyContest238 extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int ans = longestBeautifulSubstring(str);
		System.out.println(ans);
		int[] nums = get1DArray();
		int k = sc.nextInt();
		ans = maxFrequency(nums, k);
		System.out.println(ans);
		sc.close();
	}

	/**
	 * @param nums
	 * @param k
	 * @return
	 */
	private static int maxFrequency(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;

		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			int diff = nums[i] - nums[i - 1];
			int prevCount = dp[i - 1];

			if (diff <= k) {
				k -= diff;
				if (dp[i] * dp[i - 1] <= k) {
					dp[i] = dp[i] + dp[i - 1];
				}
			}
		}

		return 0;
	}

	/**
	 * @param str
	 * @return
	 */
	private static int longestBeautifulSubstring(String str) {
		// check for base case
		if (str == null || str.length() < 5)
			return 0;

		String vowelString = "aeiou";
		int count = 5;
		int subCount = 0;
		int max = 0;
		for (int i = 0; i < str.length(); i++) {
			count = 5;
			subCount = 0;
			if (str.charAt(i) == 'a') {
				count--;
				while (++i < str.length()
						&& (vowelString.indexOf(str.charAt(i)) - vowelString.indexOf(str.charAt(i - 1)) == 1
								|| vowelString.indexOf(str.charAt(i)) - vowelString.indexOf(str.charAt(i - 1)) == 0)) {
					if (vowelString.indexOf(str.charAt(i)) - vowelString.indexOf(str.charAt(i - 1)) == 1)
						count--;
					subCount++;
				}
				if (count == 0 && max < subCount) {
					max = subCount + 1;
				} else {
					i -= 1;
				}
			}
		}

		return max;
	}

}
