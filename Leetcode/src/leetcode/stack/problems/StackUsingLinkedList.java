/**
 * 
 */
package leetcode.stack.problems;

import leetcode.linkedlist.prolems.ListNode;

/**
 * @author Hardik
 *
 *         Date : Apr 2, 2021 Time : 10:07:46 AM
 */
public class StackUsingLinkedList {

	private ListNode head;
	private int size;

	/**
	 * 
	 */
	public StackUsingLinkedList() {
		head = null;
		size = 0;
	}

	public int getSize() {
		return size;
	}

	public int top() throws StackEmptyException {
		if (head == null) {
			throw new StackEmptyException();
		}
		return head.val;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void push(int element) {
		if (head == null) {
			head = new ListNode(element);
		} else {
			ListNode newNode = new ListNode(element);
			newNode.next = head;
			head = newNode;
		}
	}

	public int pop() throws StackEmptyException  {
		if (head == null) {
			throw new StackEmptyException();
		}
		int val = head.val;
		head = head.next;
		return val;
	}

	public void print() {
		if (head == null) {
			System.out.println("Stack is empty");
			return;
		}
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}

	
	
}
