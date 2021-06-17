/**
 * 
 */
package leetcode.array.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Hardik
 *
 *         Date : 09-May-2021 Time : 1:33:29 pm
 */

public class Codechef {
	static int modulo = 1000000007;

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		System.out.println((int) Math.pow(2, 30));
		HashSet<Integer> set = new HashSet<>();
		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
		ReentrantLock lock = new ReentrantLock();

		HashMap<FastReader, Integer> map1 = new HashMap<>();
		// map1.put(null, "ABC");
		int t = sc.nextInt();

		// Question 1
		/*
		 * while (t-- > 0) { long n = sc.nextLong(); long x = sc.nextLong(); long k =
		 * sc.nextLong(); ballWithHole(n, x, k); }
		 */

		// Question 2
		while (t-- > 0) {
			int end = sc.nextInt();
			int ways = XOREquality(0, end);
			System.out.println(ways);
		}
	}

	/**
	 * @param start
	 * @param end
	 * @return
	 */
	private static int XOREquality(long start, long end) {
		return (int) (Math.pow(2, end % modulo - 1)) % modulo;
	}

	/**
	 * @param n
	 * @param x
	 * @param k
	 */
	private static void ballWithHole(long n, long x, long k) {

		if (x % k == 0 || (x % k) == ((n + 1) % k))
			System.out.println("YES");
		else
			System.out.println("NO");

	}

}
