/**
 * 
 */
package leetcode.math.probems;

import java.util.Scanner;

/**
 * @author NIPC-43
 *
 *         Date : Jan 14, 2021 Time : 4:11:08 PM
 */
public class SubtractProductAndSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		n = subtractProductAndSum(n);
		System.out.println(n);
		sc.close();

	}

	/**
	 * @param n
	 * @return
	 */
	private static int subtractProductAndSum(int n) {
		int sum = 0;
		int prod = 1;
		while (n > 0) {
			int rem = n % 10;
			sum += rem;
			prod *= rem;
			n = n / 10;
		}
		return prod - sum;
	}

}
