/**
 * 
 */
package leetcode.string.problems;

import java.util.Scanner;

/**
 * 
 * 
 * Implement a method to perform basic string compression using the counts of
 * repeated characters. For example, the string aabcccccaaa would become
 * a2blc5a3. If the "compressed" string would not become smaller than the
 * original string, your method should return the original string. You can
 * assume the string has only uppercase and lowercase letters (a - z).
 * 
 * @author Hardik
 *
 *         Date : 14-Apr-2021 Time : 11:24:24 pm
 */
public class StringCompression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String compressedString = compressString(str);
		System.out.println(compressedString);
		sc.close();
	}

	/**
	 * @param str
	 * @return
	 */
	private static String compressString(String str) {
		if (str.length() == 1)
			return str;
		int count = 1;
		StringBuilder s = new StringBuilder();
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1))
				count++;
			else {
				s.append(str.charAt(i - 1)).append("" + count);
				count = 1;
			}
		}
		if (count > 1)
			s.append(str.charAt(str.length() - 1)).append(count);
		else
			s.append(str.charAt(str.length() - 1)).append(count);
		return s.toString();
	}

}
