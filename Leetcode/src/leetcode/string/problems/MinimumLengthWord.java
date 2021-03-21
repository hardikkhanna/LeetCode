/**
 * 
 */
package leetcode.string.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Mar 10, 2021 Time : 12:47:17 PM
 */
public class MinimumLengthWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String length = minLengthWord(str);
		System.out.println(length);
	}

	/**
	 * @param str
	 * @return
	 */
	private static String minLengthWord(String input) {
		if (input.length() == 0)
			return "";
		String[] sarr = input.split(" ");
		if (sarr.length == 1)
			return sarr[0];
		String str = "";
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < sarr.length; i++) {
			if (sarr[i].length() < min) {
				min = sarr[i].length();
				str = sarr[i];
			}
		}
		return str;
	}

}
