package leetcode.string.problems;

import java.io.*;
import java.util.*;

public class isBeautiful {
	static Map<Integer, Boolean> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int t_i = 0; t_i < T; t_i++) {
			String[] str = br.readLine().split(" ");
			int l = Integer.parseInt(str[0]);
			int r = Integer.parseInt(str[1]);

			long out_ = solve(l, r);
			System.out.println(out_);

		}

		wr.close();
		br.close();
	}

	static long solve(int l, int r) {
// Your code goes here
		long sum = 0;
		map = new HashMap<>();
		while (l <= r) {

			if (isBeautiful(l))
				sum += l;

			l++;
		}
		return sum;

	}

	private static boolean helper(int n) {
		// Keep replacing n with
		// sum of squares of digits
		// until we either reach 1
		// or we end up in a cycle
		while (true) {

			// Number is Happy if
			// we reach 1
			if (n == 1)
				return true;

			// Replace n with sum
			// of squares of digits
			n = sumDigits(n);

			// Number is not Happy
			// if we reach 4
			if (n == 4)
				return false;
		}
	}

	private static boolean isBeautiful(int num) {

		if (num == 1)
			return true;
		if (map.containsKey(num)) {
			return map.get(num);
		}
		num = sumDigits(num);
		if (num == 4) {
			return false;
		}
		Boolean ans = isBeautiful(num);
		map.put(num, ans);
		return ans;

	}

	private static int sumDigits(int num) {
		int c = 0;
		while (num != 0) {
			int rem = num % 10;
			c += rem * rem;
			num /= 10;
		}
		return c;
	}
}