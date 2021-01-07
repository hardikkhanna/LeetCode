/**
 * 
 */
package leetcode.linkedlist.prolems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 4, 2021 Time : 9:56:09 AM
 */
public class ScannerInput {

	static Scanner sc = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static ListNode scannerInput() {
		int n = sc.nextInt();
		ListNode head = null;
		while (n-- > 0) {
			head = insertNode(head, sc.nextInt());

		}
		// sc.close();
		return head;
	}

	/**
	 * @param head
	 * @param nextInt
	 */
	private static ListNode insertNode(ListNode head, int nextInt) {
		if (head == null) {
			head = new ListNode();
			head.val = nextInt;
			head.next = null;
			return head;
		}
		ListNode temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new ListNode(nextInt);
		return head;
	}

	public static void printLinkedList(ListNode head) {
		while (head != null) {
			System.out.print(head.val);
			head = head.next;

		}
	}

}
