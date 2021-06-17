/**
 * 
 */
package leetcode.string.problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *
 *         Question : Given two strings, write a method to decide if one is a
 *         permutation of the other.
 * 
 * 
 */
public class CheckPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		Boolean ans = checkPermutation(str1, str2);
		System.out.println(ans);
		sc.close();
	}

	/**
	 * @param str1
	 * @param str2
	 * @return true is the string is permutation of another
	 */
	private static Boolean checkPermutation(String str1, String str2) {

		// Approach 1 : Sort the Strings and match each Strings
		// Time Complexity : O(nlogn) ansd Space Complexity : O(s) where s is the size
		// of the String

		// if length is not equal return false
		if (str1.length() != str2.length())
			return false;

		// convert the strings to character arrays and sort the strings
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);

		System.out.println(new String(ch1).equals(new String(ch2)));

		// Approach 2 :create a frequency array and store the frequencies of character
		// os str1 in
		// this array
		// Time Complexity - O(n) and Space Complexity - O(1)

		int[] char_count = new int[26];
		for (int i = 0; i < str1.length(); i++) {
			char_count[str1.charAt(i) - 'a']++;
		}
		// now for each character in str2 decrement the value in frequency arr
		for (int i = 0; i < str2.length(); i++) {
			char_count[str2.charAt(i) - 'a']--;

			// If any point value at index i becomes less than 0 then return false
			// as this point indicates characters are not matching
			if (char_count[str2.charAt(i) - 'a'] < 0)
				return false;
		}
		return true;
	}

}
