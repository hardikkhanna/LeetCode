/**
 * 
 */
package leetcode.array.problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author NIPC-43
 *
 *         Date : Jan 3, 2021 Time : 1:00:58 PM
 */
public class UniqueIntegersSumToZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ans = sumZero(n);
		Arrays.stream(ans).forEach(i -> System.out.println(ans[i]));
		sc.close();
	}

	/**
	 * @param n
	 * @return
	 */
	private static int[] sumZero(int n) {
		int[] ans = new int[n];
		ans[0] = 0;
		int k = 1;
		n = n % 2 == 0 ? n : n - 1;
		for (int i = 0; i < n; i += 2) {
			ans[i] = k++;
			if (i + 1 != n)
				ans[i + 1] = -ans[i];
		}
		return ans;
	}

}
