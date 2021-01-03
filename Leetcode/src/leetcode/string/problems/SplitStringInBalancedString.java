/**
 * 
 */
package leetcode.string.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 3, 2021 Time : 2:38:36 PM
 */
public class SplitStringInBalancedString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int ans = balancedStringSplit(str);
		System.out.println(ans);
		sc.close();
	}

	/**
	 * @param str
	 * @return
	 */
	private static int balancedStringSplit(String s) {
		int res = 0, cnt = 0;
		for (int i = 0; i < s.length(); ++i) {
			cnt += s.charAt(i) == 'L' ? 1 : -1;
			if (cnt == 0)
				++res;
		}
		return res;
	}

}
