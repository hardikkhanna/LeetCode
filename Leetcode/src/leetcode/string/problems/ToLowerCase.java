/**
 * 
 */
package leetcode.string.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 3, 2021 Time : 2:54:15 PM
 */
public class ToLowerCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str = toLowerCase(str);
		System.out.println(str);
		sc.close();
	}

	/**
	 * @param str
	 * @return
	 */
	private static String toLowerCase(String str) {
		return str.toLowerCase();
	}

}
