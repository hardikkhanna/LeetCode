/**
 * 
 */
package leetcode.sort.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 8, 2021 Time : 7:02:19 PM
 */
public class LargestNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0, j = 1;
		for (int i = 1; i <= n; i += 7) {
			if (i >= 8)
				count += 28 * (j++);
		}
		for (int i = 1; i < n % 7; i++) {
			count += i;
		}
		System.out.println(count);

	}

}
