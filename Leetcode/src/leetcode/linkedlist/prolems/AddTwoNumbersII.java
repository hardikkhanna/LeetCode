/**
 * 
 */
package leetcode.linkedlist.prolems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 18, 2021 Time : 11:39:31 PM
 */
class NodeII {
	int data;
	NodeII next;

	NodeII(int d) {
		data = d;
		next = null;
	}
}

public class AddTwoNumbersII {

	static void printList(NodeII n) {
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		while (T-- > 0) {

			int n = sc.nextInt();
			int val = sc.nextInt();

			NodeII first = new NodeII(val);
			NodeII tail = first;
			for (int i = 0; i < n - 1; i++) {
				val = sc.nextInt();
				tail.next = new NodeII(val);
				tail = tail.next;
			}

			int m = sc.nextInt();
			val = sc.nextInt();

			NodeII second = new NodeII(val);
			tail = second;
			for (int i = 0; i < m - 1; i++) {
				val = sc.nextInt();
				tail.next = new NodeII(val);
				tail = tail.next;
			}

			SolutionII g = new SolutionII();
			NodeII res = g.addTwoLists(first, second);
			printList(res);
		}
	}
}

// } Driver Code Ends
class SolutionII {
	// Function to add two numbers represented by linked list.

	static NodeII addedListHead;
	static int carry;

	static NodeII addTwoLists(NodeII h1, NodeII h2) {
		NodeII temp1 = h1;
		NodeII temp2 = h2;
		int length1 = getSize(h1);
		int length2 = getSize(h2);
		int difference = Math.abs(length1 - length2);
		if (difference > 0) {
			if (length1 > length2) {
				while (temp1 != null && difference-- > 1) {
					temp1 = temp1.next;
				}
				addSameLength(temp1.next, h2);
				temp1.next = null;
				temp2 = h1;
				propagateCarry(temp2);
				temp1.next = addedListHead;
				if (carry > 0) {
					h1 = addNewNode(h1);
				}
				return h1;
			} else {
				while (temp2 != null && difference-- > 1) {
					temp2 = temp2.next;
				}
				addSameLength(temp1, temp2.next);
				temp2.next = null;
				temp1 = h2;
				propagateCarry(temp1);
				temp2.next = addedListHead;
				if (carry > 0) {
					h2 = addNewNode(h2);
				}
				return h2;
			}
		} else {
			addSameLength(h1, h2);
			if (carry > 0)
				return addNewNode(addedListHead);
		}
		return addedListHead;
	}

	private static NodeII addNewNode(NodeII h1) {
		if (h1 == null)
			return null;
		NodeII newNode = new NodeII(carry);
		newNode.next = h1;
		return newNode;

	}

	private static void propagateCarry(NodeII temp1) {
		if (temp1 == null)
			return;
		propagateCarry(temp1.next);
		int sum = temp1.data + carry;
		temp1.data = sum % 10;
		carry = sum / 10;
	}

	private static void addSameLength(NodeII h1, NodeII h2) {
		if (h1 == null || h2 == null)
			return;
		addSameLength(h1.next, h2.next);
		int sum = (carry + h1.data + h2.data) % 10;
		carry = (carry + h1.data + h2.data) / 10;
		if (addedListHead == null)
			addedListHead = new NodeII(sum);
		else {
			NodeII newNode = new NodeII(sum);
			newNode.next = addedListHead;
			addedListHead = newNode;
		}
	}

	private static int getSize(NodeII h1) {
		NodeII temp = h1;
		int count = 0;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}
}