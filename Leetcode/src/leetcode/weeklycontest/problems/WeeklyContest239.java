/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 02-May-2021 Time : 8:18:50 am
 */
public class WeeklyContest239 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int k = sc.nextInt();
		int minSwaps = getMinSwaps(str, k);
		System.out.println(minSwaps);
		sc.close();
	}

	/**
	 * @param str
	 * @param k
	 * @return
	 */
	private static int getMinSwaps(String num, int k) {
		List<Integer> list = new ArrayList<Integer>();
		for (char c : num.toCharArray()) {

			list.add(Character.getNumericValue(c));

		}
		Collections.sort(list);

		String ans = "";
		int index = 0;
		for (int i = 0; i < k; i++) {
			StringBuilder str = new StringBuilder(num);
			for (int j = str.length() - index - 1; j >= 0; j--) {
				if (str.charAt(j) < list.get(j)) {
					char c = (char) (list.get(j) + '0');
					str.setCharAt(j, c);
					index = j;
					ans = str.toString();
				}
			}
		}

		return Integer.valueOf(ans);
	}

}
