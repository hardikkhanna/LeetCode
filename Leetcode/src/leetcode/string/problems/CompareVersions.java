/**
 * 
 */
package leetcode.string.problems;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 17-May-2021 Time : 4:48:01 pm
 */
public class CompareVersions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String versionA = sc.next();
		String versionB = sc.next();
		int ans = compareVersion(versionA, versionB);
		System.out.println(ans);

	}

	/**
	 * @param versionA
	 * @param versionB
	 * @return
	 */
	private static int compareVersion(String a, String b) {
		if (a.length() == 0 && b.length() == 0)
			return 0;

		String[] str1 = a.split("\\.");
		String[] str2 = b.split("\\.");

		int start = 0;
		while (start < str1.length && start < str2.length) {
			BigInteger val1 = new BigInteger(str1[start]);
			BigInteger val2 = new BigInteger(str2[start]);
			if (val1.longValue() > val2.longValue())
				return 1;
			else if (val1.longValue() < val2.longValue())
				return -1;
			start++;
		}

		while (start < str1.length) {
			BigInteger val1 = new BigInteger(str1[start]);
			if (val1 != BigInteger.ZERO)
				return 1;
			start++;
		}

		while (start < str2.length) {
			BigInteger val2 = new BigInteger(str2[start]);
			if (val2 != BigInteger.ZERO)
				return -1;
			start++;
		}

		return 0;
	}

}