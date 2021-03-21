/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.util.HashMap;
import java.util.Scanner;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : Mar 14, 2021 Time : 8:17:41 AM
 */
public class WeeklyContest232 extends ScannerInput{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		Boolean ans = stringSwap(str1, str2);
		System.out.println(ans);
		int[][] edges = get2DArray();
		int center = findCenter(edges);
		System.out.println(center);
		sc.close();
	}

	/**
	 * @param edges
	 * @return
	 */
	private static int findCenter(int[][] edges) {

		int firstIndex = edges[0][0];
		int secondIndex = edges[0][1];
		int firstCount = 1;
		for (int i = 1; i < edges.length; i++) {
			if (edges[i][0] == firstIndex || edges[i][1] == firstIndex) {
				firstCount++;
			}
		}
		return firstCount == edges.length ? firstIndex : secondIndex;
	}

	/**
	 * @param str1
	 * @param str2
	 * @return
	 */
	private static Boolean stringSwap(String s1, String s2) {
		if (s1.equals(s2))
			return true;

		HashMap<Character, Integer> mp = new HashMap<>();
		long count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				count++;
			if (mp.containsKey(s1.charAt(i))) {
				int val = mp.get(s1.charAt(i));
				mp.put(s1.charAt(i), +val + 1);
			}

			else
				mp.put(s1.charAt(i), 1);
		}
		if (count != 2)
			return false;

		for (int i = 0; i < s2.length(); i++) {
			if (!mp.containsKey(s2.charAt(i)))
				return false;
			if (mp.get(s2.charAt(i)) == 0)
				return false;
			int val = mp.get(s2.charAt(i));
			mp.put(s2.charAt(i), val - 1);
		}

		return true;

	}

}
