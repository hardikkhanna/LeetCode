/**
 * 
 */
package leetcode.dp.problems.easy;

import java.util.Scanner;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : Feb 16, 2021 Time : 4:35:33 PM
 */
public class UglyNumbers extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		long startTime = System.currentTimeMillis();
		int ans = normalApproach(num);
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken for normal approach : " + Math.subtractExact(endTime, startTime) / 1000);
		//System.out.println("Answer from Normal Approach : " + ans);
		sc.close();
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int normalApproach(int num) {
		int i = 1;

		// ugly number count
		int count = 1;

		// check for all integers
		// until count becomes n
		while (num > count) {
			i++;
			if (isUgly(i) == 1)
				count++;
		}
		return i;
	}

	/**
	 * @param i
	 * @return
	 */
	private static int isUgly(int no) {
		no = maxDivide(no, 2);
		no = maxDivide(no, 3);
		no = maxDivide(no, 5);

		return (no == 1) ? 1 : 0;
	}

	/**
	 * @param no
	 * @param i
	 * @return
	 */
	private static int maxDivide(int a, int b) {
		while (a % b == 0)
			a = a / b;
		return a;
	}

}
