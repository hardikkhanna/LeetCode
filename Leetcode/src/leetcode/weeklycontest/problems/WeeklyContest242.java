/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.util.Arrays;
import java.util.Scanner;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : 23-May-2021 Time : 8:28:51 am
 */
public class WeeklyContest242 extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] distance = get1DArray();
		double hour = sc.nextDouble();
		int minSpeed = minSpeedOnTime(distance, hour);
		System.out.println(minSpeed);
//		String str = sc.next();
//		int minJump = sc.nextInt();
//		int maxJump = sc.nextInt();
//		Boolean ans = canReach(str, minJump, maxJump);
//		System.out.println(ans);
	}

	/**
	 * @param s
	 * @param minJump
	 * @param maxJump
	 * @return
	 */
	public static boolean canReach(String s, int minJump, int maxJump) {
		int n = s.length(), pre = 0;
		boolean[] dp = new boolean[n];
		dp[0] = true;
		for (int i = 1; i < n; ++i) {
			if (i >= minJump && dp[i - minJump])
				pre++;
			if (i > maxJump && dp[i - maxJump - 1])
				pre--;
			dp[i] = pre > 0 && s.charAt(i) == '0';
		}
		return dp[n - 1];
	}

	private static boolean canReach(String s, int start, int minJump, int maxJump) {
		if (start >= s.length() || s.charAt(start) == '1')
			return false;
		if (start == s.length() - 1)
			return true;

		return canReach(s, start + minJump, minJump, maxJump) || canReach(s, start + maxJump, minJump, maxJump);
	}

	/**
	 * @param distance
	 * @param hour
	 * @return
	 */
	private static int minSpeedOnTime(int[] dist, double hour) {

		double length = dist.length;
		if (hour < length - 1)
			return -1;

		int maxSpeed = 1000000;

		int minSpeed = 1;
		int ans = -1;
		while (minSpeed <= maxSpeed) {
			int mid = (minSpeed + maxSpeed) / 2;
			if(mid == 100000)
				System.out.println("Reached");
			double currTime = 0;
			for (int i = 0; i < dist.length - 1; i++) {
				currTime += Math.ceil((double)1.0 * dist[i] / mid);
			}
			currTime += (1.0 * dist[dist.length - 1] / mid);

			if (currTime > hour) {
				minSpeed = mid + 1;
			} else {
				ans = minSpeed;
				maxSpeed = mid - 1;
			}
		}

		return ans;

	}

}
