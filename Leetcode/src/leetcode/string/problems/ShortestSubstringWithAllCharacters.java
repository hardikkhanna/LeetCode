/**
 * 
 */
package leetcode.string.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 18-May-2021 Time : 8:41:36 pm
 */
public class ShortestSubstringWithAllCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String ans = shortestSubString(str);
		System.out.println(ans);
	}

	public static String shortestSubString(String s) {
		// Write your code here.
		if (s == null || s.length() == 0) {
			return "";
		}
		int[] freq = new int[26];
		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}

		int start = 0;
		int end = s.length() - 1;
		Boolean first = false;
		Boolean second = false;
		int i = 0;
		int j = 0;
		while (start < end) {
			if (!first) {
				freq[s.charAt(start) - 'a']--;
				if (freq[s.charAt(start) - 'a'] == 0) {
					first = true;
					i = start;
				}
			}
			if (!second) {
				freq[s.charAt(end) - 'a']--;
				if (freq[s.charAt(end) - 'a'] == 0) {
					second = true;
					j = end;
				}
			}
			if (first && second) {
				return s.substring(i, j + 1);
			}
			start++;
			end--;
		}

		return s.length() == 2 ? s.substring(1) : s.substring(i, j);
	}
}
