/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Mar 7, 2021 Time : 8:01:26 AM
 */
public class WeeklyContest231 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Boolean ans = checkOnesSegment(str);
		System.out.println(ans);
		sc.close();
	}

	/**
	 * @param str
	 * @return
	 */
	private static Boolean checkOnesSegment(String str) {
		if (str.length() <= 2)
			return true;
		Boolean flag = false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '0') {
				flag = true;
			} else if (flag && str.charAt(i) == '1') {
				return false;
			}
		}
		return true;
	}

}
