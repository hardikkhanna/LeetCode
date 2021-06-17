/**
 * 
 */
package leetcode.array.problems;

import java.util.Stack;

/**
 * @author Hardik
 *
 *         Date : 15-May-2021 Time : 1:25:21 pm
 */

class Pair {
	int data;
	int min;

	Pair(int data, int min) {
		this.data = data;
		this.min = min;
	}
}

public class StackUSE {

	private Stack<Pair> st;
	private int size;

	/**
	 * 
	 */
	public StackUSE() {
		st = new Stack<>();
		size = 0;
	}

	public void push(int ele) {
		if (size == 0) {
			Pair p = new Pair(ele, ele);
			st.push(p);
		} else {
			int min = Math.min(ele, st.peek().min);
			st.push(new Pair(ele, min));
		}
		size++;
	}

	public void pop() {
		if (st.isEmpty())
			return;
		st.pop();
		return;
	}

}
