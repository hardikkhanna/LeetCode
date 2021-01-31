/**
 * 
 */
package leetcode.stack.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 30, 2021 Time : 3:44:42 PM
 */
public class RemoveOuterMostParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "(()(()))";
		str = removeOuterParentheses(str);
		System.out.println(str);
	}

	/**
	 * @param str
	 * @return
	 */
	private static String removeOuterParentheses(String S) {
		StringBuilder s = new StringBuilder();
		int opened = 0;
		for (char c : S.toCharArray()) {
			if (c == '(' && opened++ > 0)
				s.append(c);
			if (c == ')' && opened-- > 1)
				s.append(c);
		}
		return s.toString();
	}

}
