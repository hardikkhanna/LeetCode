/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 11-Apr-2021 Time : 8:07:24 am
 */
public class WeeklyContest236 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int[] arr = { 9, 72, 34, 29, -49, -22, -77, -17, -66, -75, -44, -30, -24 };
//		int ans = arraySign(arr);
//		System.out.println(ans);
//
//		int n = sc.nextInt();
//		int k = sc.nextInt();
//		int winner = findTheWinner(n, k);
//		System.out.print(winner);

		long n = 5;
		Double d = (double) n;
		double ans = Math.floor(Math.sqrt(d));
		System.out.println((long) ans);
	}

	/**
	 * @param n
	 * @param k
	 * @return
	 */
	private static int findTheWinner(int n, int k) {
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		return 0;
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int arraySign(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0)
				count++;
			if (nums[i] == 0)
				return 0;
		}
		return count % 2 == 0 ? 1 : -1;

	}

}
