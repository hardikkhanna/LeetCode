/**
 * 
 */
package leetcode.string.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Write a method to replace all spaces in a string with '%20'. You may
 *         assume that the string has sufficient space at the end to hold the
 *         additional characters, and that you are given the "true" length of
 *         the string. (Note: If implementing in Java, please use a character
 *         array so that you can perform this operation in place.) EXAMPLE
 *         Input: "Mr John Smith ", 13 Output: "Mr%20John%20Smith"
 *
 *         Date : 14-Apr-2021 Time : 8:46:27 pm
 */
public class URLify {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int length = sc.nextInt();
		String url_string = convertString(str.toCharArray(), length);
		System.out.println(url_string);
		sc.close();
	}

	/**
	 * @param str
	 * @param length
	 * @return
	 */
	private static String convertString(char[] str, int length) {
		int count_whitespace = 0;
		// count the whitespaces
		for (char c : str) {
			if (c == ' ')
				count_whitespace++;
		}

		// generate the original length of the array
		int original_length = length + count_whitespace * 2;
		if(length < str.length) str[length] = '\0';
		char[] old_string = str;
		str = new char[original_length];
		for (int i = length - 1; i >= 0; i--) {
			if (old_string[i] != ' ') {
				str[original_length - 1] = old_string[i];
				original_length--;
			} else {
				str[original_length - 1] = '0';
				str[original_length - 2] = '2';
				str[original_length - 3] = '%';
				original_length -= 3;
			}
		}
		return new String(str);
	}

}
