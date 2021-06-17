/**
 * 
 */
package leetcode.string.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 19-May-2021 Time : 12:48:28 pm
 */
public class MinimumCostToGivenString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			String str1 = sc.next();
			String str2 = sc.next();
			int ans = minCostToGivenString(str1, str2);
			System.out.println(ans);
		}
		sc.close();
	}

	/**
	 * @param str1
	 * @param str2
	 * @return
	 */
	private static int minCostToGivenString(String str1, String str2) {
		int freq[] = new int[52];

		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z') {
				freq[str1.charAt(i) - 'a']++;
			} else {
				freq[str1.charAt(i) - 'A' + 26]++;
			}
		}

		for (int i = 0; i < str2.length(); i++) {
			if (str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z') {
				freq[str2.charAt(i) - 'a']--;
			} else {
				freq[str2.charAt(i) - 'A' + 26]--;
			}
		}

		for (int i = 0; i < 52; i++) {
			if (freq[i] != 0) {
				return -1;
			}
		}

		int i = 0, j = 0, ans = 0;
		// i points to str1 and j points to str2
		while (i < str1.length() && j < str2.length()) {

			if (str1.charAt(i) == str2.charAt(j)) {
				i++;
				j++;
			} else {
				i++;
				ans++;
			}
		}

		return ans;
	}

}
