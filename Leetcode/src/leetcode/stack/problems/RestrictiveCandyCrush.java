/**
 * 
 */
package leetcode.stack.problems;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author NIPC-43
 *
 *         Date : Apr 3, 2021 Time : 3:46:04 PM
 */
public class RestrictiveCandyCrush {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int k = 3;
		// sc.next();
		String str = sc.next();

		String ans = reduced_String(k, str);
		System.out.println(ans);
	}

	public static String reduced_String(int k, String s) {
		if (s.length() <= 0 || k == 0)
			return s;
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			st.push(s.charAt(i));
		}
		String ans = st.pop().toString();
		while (!st.isEmpty()) {
			if (ans.charAt(0) == st.peek()) {
				st.push(ans.charAt(0));
				ans = ans.substring(1);
				int count = k;
				while (!st.isEmpty() && count-- > 1 && ans.charAt(0) == st.peek())
					st.pop();
				ans = ans.substring(1);
			} else {
				ans = st.pop().toString() + ans;
			}
		}
		return ans;
	}

}
