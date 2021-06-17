/**
 * 
 */
package leetcode.array.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 13-Apr-2021 Time : 11:48:05 am
 */
public class MinimumStepsToOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int minSteps = countMinStepsToOne(n);
		System.out.println(minSteps);
		sc.close();
	}

	/**
	 * @param n
	 * @return
	 */
	private static int countMinStepsToOne(int n) {
		if (n <= 1)
			return 0;

		if (n % 2 == 0)
			return 1 + countMinStepsToOne(n / 2);
		if (n % 3 == 0)
			return 1 + countMinStepsToOne(n / 2);
		return 1 + countMinStepsToOne(n - 1);
	}

}
