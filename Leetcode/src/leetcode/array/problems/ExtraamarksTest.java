/**
 * 
 */
package leetcode.array.problems;

/**
 * @author Hardik
 *
 *         Date : 25-May-2021 Time : 9:58:04 pm
 */
public class ExtraamarksTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int m = 3;
		int n = 14;
		int distance = getMin(m, n);
		System.out.println(distance);

	}

	/**
	 * @param m
	 * @param n
	 * @return
	 */
	private static int getMin(int m, int n) {
		if (m >= n)
			return 0;
		int left = 1 + getMin(2 * m, n);
		int right = 1 + getMin((2 * m) + 1, n);
		return Math.min(left, right);
	}

}
