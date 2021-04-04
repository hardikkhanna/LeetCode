/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Mar 20, 2021 Time : 8:07:03 PM
 */

class AuthenticationManager {

	private int timeToLive;
	HashMap<String, Integer> map = new HashMap<String, Integer>();

	public AuthenticationManager(int timeToLive) {
		this.timeToLive = timeToLive;
	}

	public void generate(String tokenId, int currentTime) {
		// checkExpiredTokens(currentTime);
		if (tokenId != null && tokenId.length() > 0) {
			map.put(tokenId, currentTime + timeToLive);
		}
	}

	public void renew(String tokenId, int currentTime) {
		checkExpiredTokens(currentTime);
		if (tokenId != null && tokenId.length() > 0) {
			if (map.containsKey(tokenId)) {

				map.put(tokenId, timeToLive + currentTime);
			}
		}

	}

	public int countUnexpiredTokens(int currentTime) {
		checkExpiredTokens(currentTime);
		return map.size();
	}

	/**
	 * @param currentTime
	 */
	private void checkExpiredTokens(int currentTime) {
		if (!map.isEmpty()) {
			map.entrySet().removeIf(e -> e.getValue() <= currentTime);
//			for (String token : map.keySet()) {
//				map.entrySet().removeIf(e -> <boolean expression>);
//				if (map.get(token) + timeToLive < currentTime) {
//					map.remove(token);
//				}
//			}
		}

	}
}

public class BiWeeklyContest48 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int second = secondHighest(str);
		System.out.println(second);
		AuthenticationManager obj = new AuthenticationManager(13);
		obj.renew("ajvy", 1);
		System.out.println(obj.countUnexpiredTokens(3));
		System.out.println(obj.countUnexpiredTokens(4));
		obj.generate("fuzxq", 5);
		obj.generate("izmry", 7);
		obj.renew("puv", 12);
		obj.generate("ybiqb", 13);
		obj.generate("gm", 14);
		System.out.println(obj.countUnexpiredTokens(15));
		System.out.println(obj.countUnexpiredTokens(18));
		System.out.println(obj.countUnexpiredTokens(19));
		obj.renew("ybiqb", 21);
		System.out.println(obj.countUnexpiredTokens(23));
		System.out.println(obj.countUnexpiredTokens(25));
		System.out.println(obj.countUnexpiredTokens(26));
		obj.generate("aqdm", 28);
		System.out.println(obj.countUnexpiredTokens(29));
		obj.renew("puv", 30);
		sc.close();

	}

	private static int secondHighest(String s) {
		int largest = Integer.MIN_VALUE;
		int secoindLargest = largest;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				int num = Character.getNumericValue(s.charAt(i));
				if (num > largest) {
					secoindLargest = largest;
					largest = num;
				} else if (secoindLargest < num && num < largest) {
					secoindLargest = num;
				}
			}
		}
		return secoindLargest == Integer.MIN_VALUE ? -1 : secoindLargest;
	}

}
