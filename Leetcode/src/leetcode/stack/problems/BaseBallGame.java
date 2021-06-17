/**
 * 
 */
package leetcode.stack.problems;

import java.util.Stack;

/**
 * @author Hardik
 *
 *         Date : 22-Apr-2021 Time : 12:53:26 pm
 */
public class BaseBallGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] ops = { "5", "-2", "4", "C", "D", "9", "+", "+" };
		int ans = calPoints(ops);
		System.out.println(ans);

	}

	/**
	 * @param ops
	 * @return
	 */
	private static int calPoints(String[] ops) {
		// check for base cases
		if (ops == null || ops.length == 0)
			return 0;

		// create a Stack to store the operations
		Stack<Integer> st = new Stack<Integer>();

		for (String s : ops) {
			if (s.equals("C")) {
				st.pop();
			} else if (s.equals("D")) {
				st.push(st.peek() * 2);
			} else if (s.equals("+")) {
				int val1 = st.pop();
				int val2 = st.pop();
				int val3 = val1 + val2;
				st.push(val2);
				st.push(val1);
				st.push(val3);
			} else {
				st.push(Integer.valueOf(s));
			}
		}

		int sum = 0;
		while (!st.isEmpty()) {
			sum += st.pop();
		}
		return sum;
	}

}
