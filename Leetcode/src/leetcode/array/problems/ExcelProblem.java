/**
 * 
 */
package leetcode.array.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Mar 7, 2021 Time : 9:35:21 PM
 */
public class ExcelProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int start = 1;
		StringBuilder colName = new StringBuilder();
		while (n > 0) {
			int rem = n % 26;
			int q = n / 26;
			if (rem == 0) {
				colName.append("z");
				n = q - 1;
				continue;

			}
			colName.append((char)( 96 + rem));
			n = q;
		}
		System.out.print(colName.reverse());

	}

}
