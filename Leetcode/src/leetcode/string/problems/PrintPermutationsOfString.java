/**
 * 
 */
package leetcode.string.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 25-May-2021 Time : 7:07:59 pm
 */
public class PrintPermutationsOfString {

	private static List<String> ans;
	private static StringBuilder temp;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		List<String> list = findPermutations(str);
		System.out.println(list);
		sc.close();
	}

	/**
	 * @param str
	 * @return
	 */
	private static List<String> findPermutations(String str) {
		StringBuilder s = new StringBuilder(str);
		ans = new ArrayList<>();
		temp = new StringBuilder();
		findPermutations(s, 0);
		return ans;
	}

	/**
	 * @param str
	 * @param start
	 * @param string
	 */
	private static void findPermutations(StringBuilder str, int start) {
		if (str == null || str.length() == 0 || start > str.length()) {
			return;
		}

		if (temp.length() == str.length()) {
			ans.add(temp.toString());
			return;
		}

		for (int i = start; i < str.length(); i++) {
			swap(str, i, start);
			temp.append(str.charAt(start));
			findPermutations(str, start + 1);
			temp.deleteCharAt(temp.length() - 1);
			swap(str, i, start);
		}
	}

	/**
	 * @param str
	 * @param i
	 * @param start
	 */
	private static void swap(StringBuilder str, int i, int start) {

		char temp = str.charAt(i);
		str.setCharAt(i, str.charAt(start));
		str.setCharAt(start, temp);
	}

}
