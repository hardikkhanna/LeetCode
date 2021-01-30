/**
 * 
 */
package leetcode.array.problems;

import java.util.Stack;

/**
 * @author Hardik
 *
 *         Date : Jan 30, 2021 Time : 3:20:35 PM
 */
public class ImplementQueueUsingStack {

	Stack<Integer> st1 = new Stack<>();
	Stack<Integer> st2 = new Stack<>();
	int size = 0;

	public void enQueue(int num) {
		size++;
		st1.push(num);
	}

	public void deQueue() {
		if (st1.isEmpty()) {
			System.out.println("Queue is Empty Nothing to Dequeue");
			return;
		}
		while (!st1.isEmpty()) {
			st2.push(st1.pop());
		}
		System.out.println(st2.pop());
		size--;
		while (!st2.isEmpty()) {
			st1.push(st2.pop());
		}
	}

	public int peek() {
		if (st1.isEmpty()) {
			System.out.println("Queue is Empty");
			return -1;
		}
		while (!st1.isEmpty()) {
			st2.push(st1.pop());
		}
		int temp = st2.peek();
		while (!st2.isEmpty()) {
			st1.push(st2.pop());
		}
		return temp;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ImplementQueueUsingStack queue = new ImplementQueueUsingStack();
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		System.out.println("Size of queue : " + queue.getSize());
		System.out.println("Top Element of Queue : " + queue.peek());
		queue.deQueue();
		System.out.println("Top Element of Queue : " + queue.peek());
		queue.deQueue();
		System.out.println("Top Element of Queue : " + queue.peek());
		queue.deQueue();
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

}
