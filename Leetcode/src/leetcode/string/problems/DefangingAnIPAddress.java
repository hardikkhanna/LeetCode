/**
 * 
 */
package leetcode.string.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 3, 2021 Time : 2:27:31 PM
 */
public class DefangingAnIPAddress {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str = defangIPaddr(str);
		System.out.println(str);
		sc.close();
	}

	/**
	 * @param str
	 * @return
	 */
	private static String defangIPaddr(String str) {
		return str.replace(".", "[.]");
	}

}
