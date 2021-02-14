/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : Jan 31, 2021 Time : 8:19:36 AM
 */
public class WeeklyContest226 extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		question1(sc);
		question2(sc);
		question3(sc);
	}

	/**
	 * @param sc
	 */
	private static void question3(Scanner sc) {
		int[][] adjacentPairs = get2DArray();
		int[] ans = restoreArray(adjacentPairs);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	/**
	 * @param adjacentPairs
	 * @return
	 */
	private static int[] restoreArray(int[][] adjacentPairs) {
		String str = "";
		for (int i = 0; i < adjacentPairs.length; i++) {
			for (int j = i; j < adjacentPairs[i].length; j++) {
				if (!str.contains(String.valueOf(adjacentPairs[i][j]))) {
					str += String.valueOf(adjacentPairs[i][j]);
				}
			}
		}
		return null;
	}

	/**
	 * @param sc
	 */
	private static void question2(Scanner sc) {
		String str = sc.next();
		Boolean ans = checkPartitoning(str);
		System.out.println(ans);

	}

	/**
	 * @param str
	 * @return
	 */
	private static Boolean checkPartitoning(String str) {
		List<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			for (int j = str.length() - 1; j > i; j--) {
				if (str.charAt(i) == str.charAt(j)) {
					sb = new StringBuilder(str.substring(i, j + 1)).reverse();
					String s = str.substring(i, j + 1);
					if (s.equalsIgnoreCase(sb.toString())) {
						list.add(j - i + 1);
						i = j;
					}
				}
			}
		}
		int sum = list.stream().mapToInt(i -> i.intValue()).sum();
		return sum >= str.length() - 1;
	}

	/**
	 * @param sc
	 */
	private static void question1(Scanner sc) {
		int lowlimit = sc.nextInt();
		int highlimit = sc.nextInt();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = lowlimit; i <= highlimit; i++) {
			int sum = i / 10;
			if (sum == 0) {
				if (!map.containsKey(i)) {
					map.put(i, 1);
				} else {
					map.put(i, map.get(i) + 1);
				}
			} else {
				int j = i;
				sum = 0;
				while (j != 0) {
					int rem = j % 10;
					sum += rem;
					j = j / 10;
				}
				if (!map.containsKey(sum)) {
					map.put(sum, 1);
				} else {
					map.put(sum, map.get(sum) + 1);
				}
			}

		}
		int ans = Collections.max(map.values());
		System.out.println(ans);
	}

}
