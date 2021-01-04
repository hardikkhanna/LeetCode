/**
 * 
 */
package leetcode.string.problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 3, 2021 Time : 2:35:49 PM
 */
public class CountNumberOfConsistentStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String allowed = sc.next();
		int n = sc.nextInt();
		String[] str = new String[n];
		for (int i = 0; i < str.length; i++) {
			str[i] = sc.next();
		}
		int ans = countConsistentStrings(str, allowed);
		System.out.println(ans);
		sc.close();

	}

	/**
	 * @param allowed
	 * @param str
	 * @return
	 */
	private static int countConsistentStrings(String[] words, String allowed) {
		return Arrays.stream(words).mapToInt(w -> w.chars().allMatch(c -> allowed.contains((char) c + "")) ? 1 : 0)
				.sum();
	}
}