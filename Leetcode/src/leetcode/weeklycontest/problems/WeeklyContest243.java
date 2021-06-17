/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.io.Serial;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : 30-May-2021 Time : 9:04:52 am
 */

class Process {
	int server;
	int index;
	int endTime;

	Process(int server, int index, int endTime) {
		this.server = server;
		this.index = index;
		this.endTime = endTime;
	}
}

public class WeeklyContest243 extends ScannerInput {

	/**
	 * @param args
	 */
	static List<Integer> dp;

	public static void main(String[] args) {
//		int[] servers = { 31, 96, 73, 90, 15, 11, 1, 90, 72, 9, 30, 88 };
//		int[] tasks = { 87, 10, 3, 5, 76, 74, 38, 64, 16, 64, 93, 95, 60, 79, 54, 26, 30, 44, 64, 71 };
//
//		int[] ans = assignTasks(servers, tasks);
//		for (int i = 0; i < ans.length; i++) {
//			System.out.print(ans[i] + " ");
//		}
		Scanner sc = new Scanner(System.in);
//		int t = sc.nextInt();
//		while (t-- > 0) {
//			int n = sc.nextInt();
//			int days;
//			if (n <= 2) {
//				days = 1;
//			} else {
//				days = solve(n, 2, 2);
//			}
//			System.out.println(days);
//		}
		byte b = 3;
		int c = 100;
		int a = c >> b * 3;
		System.out.println(a);
		int d = (c >> b) * 3;
		System.out.println(b);
		sc.close();
	}

	/**
	 * @param i
	 */
	private static List<Integer> generate(int i) {
		return Stream.iterate(new int[] { 0, 1 }, s -> new int[] { s[1], s[0] + s[1] }).limit(i).map(n -> n[0])
				.collect(Collectors.toList());

	}

	private static int solve(int n, int work, int days) {

		if (work > n) {
			return 0;
		}
		if (work > n) {
			return 1;
		}

		int option1 = 1 + solve(n, work + 1, days + 1);
		int option2 = 1 + solve(n, 2 * work, days + 1);
		return Math.min(option1, option2);

	}

	/**
	 * @param servers
	 * @param tasks
	 * @return
	 * 
	 *         11 10 63 95 16 85 57 83 95 6 29 71 13 70 31 83 15 32 67 98 65 56 48
	 *         38 90 5
	 * 
	 */
	private static int[] assignTasks(int[] servers, int[] tasks) {
		PriorityQueue<Process> server = new PriorityQueue<>(
				(x, y) -> x.server == y.server ? x.index - y.index : x.server - y.server);
		PriorityQueue<Process> process = new PriorityQueue<>((x, y) -> x.endTime - y.endTime);

		int[] ans = new int[tasks.length];
		int time = 0;
		for (int i = 0; i < servers.length; i++) {
			server.add(new Process(servers[i], i, 0));
		}
		int i = 0;
		while (i < tasks.length) {

			while (i < tasks.length && i <= time && !server.isEmpty()) {
				Process p = server.poll();
				ans[i] = p.index;
				process.offer(new Process(p.server, p.index, time + tasks[i]));
				i++;
			}

			if (process.isEmpty()) {
				time = process.peek().endTime;
			} else {
				time++;
			}

			while (!process.isEmpty() && process.peek().endTime <= time) {
				Process finish = process.poll();
				server.offer(new Process(finish.server, finish.index, 0));
			}

		}
		return ans;
	}

}
