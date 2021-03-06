/**
 * 
 */
package leetcode.string.problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 3, 2021 Time : 4:00:09 PM
 */
public class UniqueMorseCodeWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] str = new String[n];
		for (int i = 0; i < str.length; i++) {
			str[i] = sc.next();
		}
		int ans = uniqueMorseRepresentations(str);
		System.out.println(ans);
		sc.close();

	}

	/**
	 * @param str
	 * @return
	 */
	private static int uniqueMorseRepresentations(String[] str) {
		String[] allowed = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
				"-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
		for (int i = 0; i < str.length; i++) {
			String word = "";
			for (int j = 0; j < str[i].length(); j++) {
				int index = str[i].charAt(j) - 'a';
				word += allowed[index];
			}
			str[i] = word;
		}
		return (int) Arrays.stream(str).distinct().count();
	}

}
