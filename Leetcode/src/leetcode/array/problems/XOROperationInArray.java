/**
 * 
 */
package leetcode.array.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         10:08:21 PM
 */
public class XOROperationInArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int start = sc.nextInt();
		int ans = xorOperation(n, start);
		System.out.println(ans);
		sc.close();
	}

	/**
	 * @param n
	 * @param start
	 * @return
	 */
	private static int xorOperation(int n, int start) {
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans ^= start + 2 * i;
		}
		return ans;
	}

}
