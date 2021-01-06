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
		ListNode head = new ListNode();
		while (n-- > 0) {
			insertNode(head, sc.nextInt());

		}
		//sc.close();
		return head;
	}

	/**
	 * @param head
	 * @param nextInt
	 */
	private static void insertNode(ListNode head, int nextInt) {
		ListNode curr = head;

		ListNode temp = new ListNode();
		temp.val = nextInt;
		temp.next = null;

		while (curr.next != null) {

			curr = curr.next;
		}
		curr.next = temp;
		/// System.out.print(curr.val + "->");
	}

}
