/**
 * 
 */
package leetcode.string.problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 28, 2021 Time : 2:27:09 PM
 */
public class GetNumericString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String str = getSmallestString(n, k);
		System.out.println(str);
		sc.close();

	}

	/**
	 * @param n
	 * @param k
	 * @return
	 */
	private static String getSmallestString(int n, int k) {
		char[] chars = new char[n];
		Arrays.fill(chars, 'a');
		k -= n;
		while (k > 0) {
			if (chars[n - 1] < 'z') {
				chars[n - 1]++;
				k--;
			} else {
				n--;
			}
		}
		return new String(chars);
	}

}
