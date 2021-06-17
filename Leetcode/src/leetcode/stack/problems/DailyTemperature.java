/**
 * 
 */
package leetcode.stack.problems;

import java.util.Stack;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : 22-Apr-2021 Time : 1:20:20 pm
 */
public class DailyTemperature extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = get1DArray();
		int[] ans = dailyTemperatures(arr);
		for (int i = 0; i < ans.length; i++)
			System.out.println(ans[i]);

	}

	public static int[] dailyTemperatures(int[] T) {
		// check for base cases
		if (T == null || T.length == 0)
			return null;

		Stack<Integer> st = new Stack<Integer>();
		int[] ans = new int[T.length];
		for (int i = T.length - 1; i >= 0; i--) {
			while (!st.isEmpty() && T[i] >= T[st.peek()])
				st.pop();
			ans[i] = st.isEmpty() ? 0 : st.peek() - i;
			st.push(i);
		}
		return ans;
	}

}
