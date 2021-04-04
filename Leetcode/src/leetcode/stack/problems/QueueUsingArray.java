/**
 * 
 */
package leetcode.stack.problems;

import leetcode.binarytrees.problems.QueueEmptyException;

/**
 * @author Hardik
 *
 *         Date : Apr 2, 2021 Time : 1:03:55 PM
 */
public class QueueUsingArray {

	private int[] data;
	private int rear; // index of the element at the end of the queue
	private int front; // index of the element at the front of the queue
	private int size; // size of the Queue

	/**
	 * 
	 */
	public QueueUsingArray() {
		data = new int[5];
		rear = -1;
		front = -1;
	}

	/**
	 * @return the size of the Queue
	 */
	public int size() {
		return size;
	}

	/**
	 * 
	 * @return the front most element of the Queue
	 * @throws QueueEmptyException if the size of the Queue is ZERO.
	 */
	public int front() throws QueueEmptyException {
		if (data.length == 0) {
			throw new QueueEmptyException();
		}
		return data[front];
	}

	/**
	 * 
	 * @return if the Queue is Empty or not
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 
	 * @param element to be inserted in the Queue
	 * @throws QueueFullException once Queue has reached max capacity
	 */
	public void enqueue(int element) throws QueueFullException {
		if (size == data.length) {
			throw new QueueFullException();
		}
		if (size == 0) {
			front = 0;
		}
//		rear++;
//		if(rear == data.length) {
//			rear = 0;
//		}
		rear = (rear + 1) % data.length;
		data[rear] = element;
		size++;
	}

	/**
	 * 
	 * @return the element from the rear end
	 * @throws QueueEmptyException
	 */
	public int dequeue() throws QueueEmptyException {
		if (rear == -1) {
			throw new QueueEmptyException();
		}
		int val = data[front];
//		front++;
//		if (front == data.length)
//			front = 0;
		front = (front + 1) % data.length;
		size--;
		if (size == 0) {
			front = -1;
			rear = -1;
		}
		return val;
	}

	/**
	 * Double the capacity of the queue once it hits the maximum Capacity
	 */
	@SuppressWarnings("unused")
	private void doubleCapacity() {
		int[] temp = new int[2 * data.length];
		for (int i = 0; i < data.length; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}
}
