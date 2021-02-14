/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.util.Scanner;

/**
 * @author NIPC-43
 *
 *         Date : Feb 14, 2021 Time : 8:55:23 AM
 */
public class WeeklyContest228 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		countHomogenous(sc);

	}

	/**
	 * @param sc
	 */
	private static void countHomogenous(Scanner sc) {
		String s = sc.next();
		int count = 1;
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i + 1 != s.length() && s.charAt(i) == s.charAt(i + 1)) {
				count++;
			} else {
				for (int j = 1; j <= count; j++) {
					sum += j;
				}
				count = 1;
			}
		}
		if (count != 1) {
			for (int i = 1; i <= count; i++) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

}
