/**
 * 
 */
package leetcode.string.problems;

import java.util.Scanner;

/**
 * @author NIPC-43
 *
 *         Date : Jan 14, 2021 Time : 4:55:37 PM
 */
public class ReverseString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] ch = str.toCharArray();
		reverseString(ch);
		for (int i = 0; i < ch.length; i++) {

		}
		sc.close();
	}

	/**
	 * @param charArray
	 */
	private static void reverseString(char[] charArray) {
		char[] ch = charArray.clone();
		int j = 0;
		for (int i = charArray.length - 1; i >= 0; i--)
			ch[j++] = charArray[i];
		charArray = ch;

	}

}
