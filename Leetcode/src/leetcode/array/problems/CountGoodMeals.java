/**
 * 
 */
package leetcode.array.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 3, 2021 Time : 7:59:44 PM
 */
public class CountGoodMeals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] deliciousness = new int[n];
		for (int i = 0; i < n; i++) {
			deliciousness[i] = sc.nextInt();
		}
		int ans = countPairs(deliciousness);
		System.out.println(ans);
		sc.close();

	}

	/**
	 * @param deliciousness
	 * @return
	 */
	private static int countPairs(int[] arr) {
		int mod = 1000000007;
		Map<Integer, Integer> map = new HashMap<>();
		long res = 0;
		for (int num : arr) {
			int power = 1;
			for (int i = 0; i < 32; i++) {
				if (map.containsKey(power - num)) {
					res += map.get(power - num);
					res %= mod;
				}
				power *= 2;
			}
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		return (int) res;
	}
}