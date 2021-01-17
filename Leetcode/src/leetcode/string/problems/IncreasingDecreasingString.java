/**
 * 
 */
package leetcode.string.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author NIPC-43
 *
 *         Date : Jan 17, 2021 Time : 2:40:31 PM
 */
public class IncreasingDecreasingString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str = sortString(str);
		System.out.println(str);
		sc.close();

	}

	/**
	 * @param str
	 * @return
	 */
	private static String sortString(String str) {
		List<String> list = Arrays.asList(str.split(""));
		String ans = "";
		int j = 1;
		while (!str.isEmpty()) {
			String s = list.stream().sorted().distinct().collect(Collectors.toList()).toString().replace("[", "")
					.replace(", ", "").replace("]", "");
			for (int i = 0; i < s.length(); i++) {
				str = str.replaceFirst(String.valueOf(s.charAt(i)), "");
			}

			if (j++ % 2 == 0) {
				ans += new StringBuilder(s).reverse().toString();
			} else {
				ans += s;
			}
			list = Arrays.asList(str.split(""));
		}
		return ans;
	}

}
