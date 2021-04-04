/**
 * 
 */
package leetcode.linkedlist.prolems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Mar 29, 2021 Time : 2:58:46 PM
 */

class LinkedListNode<T> {
	T data;
	LinkedListNode<T> right;
	LinkedListNode<T> down;

	LinkedListNode(T data) {
		this.data = data;
		this.right = null;
		this.down = null;
	}
}

class ListNodeFlat<T> {
	T data;
	ListNodeFlat<T> right;

	ListNodeFlat(T data) {
		this.data = data;
		this.right = null;
	}
}

class Solution {
	public static LinkedListNode<Integer> flat(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> smallHead = head;
		LinkedListNode<Integer> ansHead = new LinkedListNode<Integer>(head.data);
		LinkedListNode<Integer> ansTail = ansHead;
		while (smallHead != null) {
			LinkedListNode<Integer> temp = smallHead;
			// LinkedListNode<Integer> tail = smallHead;
			while (smallHead.down != null) {
				smallHead = smallHead.down;
				ansTail.down = new LinkedListNode<Integer>(smallHead.data);
				ansTail = ansTail.down;
			}
			smallHead = temp;
			smallHead = smallHead.right;
			if (smallHead != null) {
				ansTail.down = new LinkedListNode<Integer>(smallHead.data);
				ansTail = ansTail.down;
			}
		}
		sort(ansHead);
		return ansHead;

	}

	/**
	 * @param ansHead
	 */
	private static void sort(LinkedListNode<Integer> head) {
		if (head == null || head.down == null)
			return;
		LinkedListNode<Integer> temp = head;
		while (temp != null) {
			LinkedListNode<Integer> right = temp.down;
			while (right != null) {
				if (temp.data > right.data) {
					int c = temp.data;
					temp.data = right.data;
					right.data = c;
				}
				right = right.down;
			}
			temp = temp.down;
		}

	}

}

public class FlattenSinglyLinkedList {

	public static void printList(LinkedListNode<Integer> head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.down;
		}

		System.out.println();
		return;
	}

	public static LinkedListNode<Integer> takeInput(Scanner s) {
		int data = s.nextInt();

		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;
		LinkedListNode<Integer> headd = null;
		LinkedListNode<Integer> taild = tail;

		while (data != -1) {
			LinkedListNode<Integer> newNode = new LinkedListNode<>(data);
			headd = null;
			if (head == null) {
				head = newNode;
				tail = newNode;
				taild = tail;
			} else {
				tail.right = newNode;
				tail = tail.right;
				taild = tail;
			}

			while (data != -1) {
				if (headd == null) {
					headd = newNode;
				} else {
					newNode = new LinkedListNode<>(data);
					taild.down = newNode;
					taild = taild.down;
				}
				data = s.nextInt();
			}
			data = s.nextInt();
		}
		return head;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		LinkedListNode<Integer> head = takeInput(s);
		head = Solution.flat(head);
		printList(head);
	}

}
