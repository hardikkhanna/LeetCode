/**
 * 
 */
package leetcode.stack.problems;

import java.util.Stack;

/**
 * @author Hardik
 *
 *         Date : 04-May-2021 Time : 11:10:37 am
 */
class Pair {
	int data;
	int min;

	Pair(int data, int min) {
		this.data = data;
		this.min = min;
	}
}
public class MinStack {

	private Stack<Pair> st;
	private int size = 0;

	/** initialize your data structure here. */
	public MinStack() {
		st = new Stack<>();
		size = 0;
	}

	public void push(int val) {
		
		if (size == 0) {
			Pair p = new Pair(val, val);
			st.push(p);
			size++;
			return;
		}
		size++;
		int mn = Math.min(val, st.peek().min);
		st.push(new Pair(val, mn));
	}

	public void pop() {
		if (size == 0 || st.isEmpty())
			return;
		st.pop();
		size--;
	}

	public int top() {
		if (size == 0 || st.isEmpty())
			return -1;
		return st.peek().data;
	}

	public int getMin() {
		if (size == 0 || st.isEmpty())
			return -1;
		return st.peek().min;
	}
}
