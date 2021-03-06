/**
 * 
 */
package leetcode.stack.problems;

import leetcode.binarytrees.problems.QueueEmptyException;
import leetcode.linkedlist.prolems.ListNode;

/**
 * @author Hardik
 *
 *         Date : Apr 4, 2021 Time : 10:19:36 AM
 */
public class QueueUsingLinkedList {

	private ListNode front;
	private ListNode rear;
	private int size;

	/**
	 * 
	 */
	public QueueUsingLinkedList() {
		front = null;
		rear = null;
		size = 0;
	}

	/*----------------- Public Functions of Queue -----------------*/
	
	/**
	 * @return the size of the Queue
	 */
	public int size() {
		return size;
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
	 * @return the front most element of the Queue
	 * @throws QueueEmptyException if the size of the Queue is ZERO.
	 */
	public int front() throws QueueEmptyException {
		if (front == null) {
			throw new QueueEmptyException();
		}
		return front.val;
	}

	/**
	 * 
	 * @param element to be inserted in the Queue
	 * @throws QueueFullException once Queue has reached max capacity
	 */
	public void enqueue(int element) {
		if (rear == null) {
			rear = new ListNode(element);
			front = rear;
			return;
		}
		rear.next = new ListNode(element);
		rear = rear.next;
		size++;
	}

	/**
	 * 
	 * @return the element from the rear end
	 * @throws QueueEmptyException
	 */
	public int dequeue() throws QueueEmptyException {
		if (front == null) {
			throw new QueueEmptyException();
		}
		int val = front.val;
		front = front.next;
		size--;
		return val;
	}

}
