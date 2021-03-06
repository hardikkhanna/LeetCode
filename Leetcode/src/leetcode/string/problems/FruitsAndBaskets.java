/**
 * 
 */
package leetcode.string.problems;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 20-May-2021 Time : 9:34:41 pm
 */
public class FruitsAndBaskets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			String str = sc.next();
			int ans = maximumFruits(str, n);
			System.out.println(ans);
		}

	}

	/**
	 * @param str
	 * @param n
	 * @return
	 */
	private static int maximumFruits(String str, int n) {
		if (str == null || str.length() == 0)
			return 0;

		int max = 1;
		HashMap<Character, Integer> map = new HashMap<>();
		int right = 0;
		int left = 0;
		while (right < str.length()) {

			if (map.size() < 2 || map.containsKey(str.charAt(right))) {
				map.put(str.charAt(right), map.getOrDefault(str.charAt(right), 0) + 1);
			} else {
				max = Math.max(max, right - left);
				while (left < right - 1 && map.size() > 1) {
					map.put(str.charAt(left), map.get(str.charAt(left)) - 1);
					if (map.get(str.charAt(left)) == 0) {
						map.remove(str.charAt(left));
					}
					left++;
				}
				map.put(str.charAt(right), 1);
			}
			right++;

		}
		max = Math.max(max, right - left);
		return max;
	}

}
