/**
 * 
 */
package codeforces.round.seventwothree;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 28-May-2021 Time : 9:34:26 pm
 */
public class B {

	/**
	 * @param args
	 */
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int t = sc.nextInt();
		while (t-- > 0) {
			int n;
			n = sc.nextInt();
			boolean flag = false;
			while (n >= 0) {
				if (n % 11 == 0) {
					flag = true;
					break;
				}
				n = n - 111;
			}
			if (flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	

}
