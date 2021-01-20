/**
 * 
 */
package leetcode.string.problems;

import java.util.Stack;

/**
 * @author NIPC-43
 *
 *         Date : Jan 20, 2021 Time : 2:26:33 PM
 */
public class ValidParenthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "[[";
		Boolean ans = isValid(str);
		System.out.println(ans);

	}

	/**
	 * @param str
	 * @return
	 */
	private static Boolean isValid(String str) {
		if (str.length() == 1)
			return false;
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
				st.push(str.charAt(i));
				continue;
			}
			if (st.isEmpty())
				return false;
			if (!((str.charAt(i) == ')' && st.pop() == '(') || (str.charAt(i) == ']' && st.pop() == '[')
					|| (str.charAt(i) == '}' && st.pop() == '{')))
				return false;
		}
		if (!st.empty())
			return false;
		return true;
	}

}
