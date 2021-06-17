/**
 * 
 */
package leetcode.stack.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 21-Apr-2021 Time : 8:28:21 pm
 */
public class SortStack extends StackUsingLinkedList {

	/**
	 * @param args
	 * @throws StackEmptyException
	 */
	public static void main(String[] args) throws StackEmptyException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		StackUsingLinkedList st = new StackUsingLinkedList();
		while (n-- > 0) {
			st.push(sc.nextInt());
		}
		sortStack(st);
		while (!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}

		sc.close();
	}

	/**
	 * @param st
	 * @throws StackEmptyException
	 */
	private static void sortStack(StackUsingLinkedList st) throws StackEmptyException {
		if (st.isEmpty())
			return;

		StackUsingLinkedList st2 = new StackUsingLinkedList();
		while (!st.isEmpty()) {
			int val = st.pop();
			while (!st2.isEmpty() && st2.top() > val)
				st.push(st2.pop());
			st2.push(val);
		}

		while (!st2.isEmpty()) {
			st.push(st2.pop());
		}

	}

}
