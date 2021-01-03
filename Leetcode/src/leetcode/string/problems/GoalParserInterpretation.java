/**
 * 
 */
package leetcode.string.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 3, 2021 Time : 2:31:09 PM
 */
public class GoalParserInterpretation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str = interpret(str);
		System.out.println(str);
		sc.close();
	}

	/**
	 * @param str
	 * @return
	 */
	private static String interpret(String command) {
		command = command.replace("()", "o").replace("(al)", "al");
		return command;
	}

}
