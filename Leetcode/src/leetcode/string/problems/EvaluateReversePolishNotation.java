/**
 * 
 */
package leetcode.string.problems;

import java.util.Stack;

/**
 * @author Hardik
 *
 *         Date : 25-May-2021 Time : 2:37:29 pm
 */
public class EvaluateReversePolishNotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String[] str = { "2", "1", "+", "3", "*" };

		int ans = evalRPN(str);
		System.out.println(ans);
	}

	/**
	 * @param str
	 * @return
	 */
	private static int evalRPN(String[] tokens) {
		if (tokens == null || tokens.length == 0) {
			return 0;
		}

		Stack<Integer> st = new Stack<>();

		for (String c : tokens) {

			if (c == "+") {
				int a = st.pop();
				int b = st.pop();
				st.push(a + b);
			} else if (c == "-") {
				int a = st.pop();
				int b = st.pop();
				st.push(a - b);
			} else if (c == "*") {
				int a = st.pop();
				int b = st.pop();
				st.push(a * b);
			} else if (c == "/") {
				int a = st.pop();
				int b = st.pop();
				st.push(b / a);
			} else {
				st.push(Integer.valueOf(c));
			}
		}
		return st.pop();
	}

}
