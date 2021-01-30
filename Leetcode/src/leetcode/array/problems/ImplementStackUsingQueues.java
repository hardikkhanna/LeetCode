/**
 * 
 */
package leetcode.array.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Hardik
 *
 *         Date : Jan 30, 2021 Time : 1:27:30 PM
 */
public class ImplementStackUsingQueues {

	int size = 0;
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();

	void push(int num) {
		q1.add(num);
		size++;
	}

	void pop() {
		if (q1.isEmpty()) {
			System.out.println("Queue is Empty nothing to pop");
			return;
		}
		while (!(q1.size() == 1)) {
			q2.add(q1.peek());
			q1.poll();
		}
		System.out.println(q1.peek());
		q1.remove();
		size--;
		while (!q2.isEmpty()) {
			q1.add(q2.poll());
		}
	}

	/**
	 * @return
	 */
	private int top() {
		if (q1.isEmpty())
			return -1;

		while (q1.size() != 1) {
			q2.add(q1.peek());
			q1.remove();
		}

		int temp = q1.peek();
		q1.remove();

		q2.add(temp);
		Queue<Integer> q = q1;
		q1 = q2;
		q2 = q;
		return temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ImplementStackUsingQueues st = new ImplementStackUsingQueues();
		st.push(1);
		st.push(2);
		st.push(3);
		System.out.println("Size of Stack : " + st.getSize());
		System.out.println("Top Element : " + st.top());
		st.pop();
		System.out.println("Top Element : " + st.top());
		st.pop();
		System.out.println("Top Element : " + st.top());
		st.pop();

	}

	int getSize() {
		return size;
	}

}
