/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.util.HashMap;
import java.util.Scanner;

import leetcode.array.problems.ScannerInput;

/**
 * @author NIPC-43
 *
 *         Date : Apr 4, 2021 Time : 8:19:47 AM
 */
public class WeeklyContest235 extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Question 1: Truncate Sentence
		String str = sc.next();
		int num = sc.nextInt();
		str = truncateSentence(str, num);
		System.out.println(str);

		// Question 2 : Finding the Users Active Minutes
		int[][] logs = get2DArray();
		int k = sc.nextInt();
		int[] ans = findingUsersActiveMinutes(logs, k);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}

		// Question 3 : Minimum Absolute Difference
		int[] num1 = get1DArray();
		int[] num2 = get1DArray();
		int diff = minAbsoluteSumDiff(num1, num2);
		System.out.print(diff);
		sc.close();

	}

	/**
	 * @param num1
	 * @param num2
	 * @return
	 */
	private static int minAbsoluteSumDiff(int[] num1, int[] num2) {
		int max = 0;
		long diff = 0;
		int index = 0;
		for (int i = 0; i < num1.length; i++) {
			if (max < Math.abs(num1[i] - num2[i])) {
				max = Math.abs(num1[i] - num2[i]);
				index = i;
			}
			diff += (int) Math.abs(num1[i] - num2[i]);
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < num1.length; i++) {
			if (min > Math.abs(num1[i] - num2[index])) {
				min = Math.abs(num1[i] - num2[index]);
			}
		}
		long ans = (diff-max+min) % 1000000007;
		return (int) ans ;
	}

	/**
	 * @param logs
	 * @param k
	 * @return
	 */
	private static int[] findingUsersActiveMinutes(int[][] logs, int k) {
		HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
		for (int i = 0; i < logs.length; i++) {
			int ID = logs[i][0];
			int MIN = logs[i][1];
			if (map.containsKey(ID)) {
				HashMap<Integer, Integer> m = map.get(ID);
				if (!m.containsKey(MIN)) {
					m.put(MIN, 1);
				}
				map.put(ID, m);
			} else {
				HashMap<Integer, Integer> m = new HashMap<>();
				m.put(MIN, 1);
				map.put(ID, m);
			}
		}
		// int index = 1;
		int[] ans = new int[k];
		for (Integer i : map.keySet()) {
			int index = map.get(i).size();
			ans[index - 1] = ++ans[index - 1];
		}

		return ans;
	}

	public static String truncateSentence(String s, int k) {
		String ans = "";
		for (String str : s.split(" ")) {
			if (k-- <= 0) {
				break;
			}
			ans += str + " ";
		}
		return ans.trim();
	}
}
