/**
 * 
 */
package codingninja.cp.course;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 29-May-2021 Time : 3:37:10 pm
 */
public class GCD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		// Method 1 : Naive Approach
		int gcd = solution1(a, b);
		System.out.println("Answer from 1st Approach : " + gcd);

		// Method 2 : Euclid Algorithms
		gcd = solution2(a, b);
		System.out.println("Answer from 2nd Arrpaoch : " + gcd);
		sc.close();
	}

	/**
	 * 
	 * Euclid Algo states that GCD(a,b) if a > b is GCD(b, a %b)
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static int solution2(int a, int b) {

		if (b > a) {
			return solution2(b, a);
		}
		if (b == 0) {
			return a;
		}

		return solution2(b, a % b);
	}

	/**
	 * @param a
	 * @param b
	 * @return
	 */
	private static int solution1(int a, int b) {
		int ans = 1;
		int min = Math.min(a, b);
		for (int i = 2; i <= min; i++) {
			if (a % i == 0 && b % i == 0) {
				ans = Math.max(ans, i);
			}
		}
		return ans;
	}

}
