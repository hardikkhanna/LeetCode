/**
 * 
 */
package leetcode.linkedlist.prolems;

/**
 * @author Hardik
 *
 *         Date : 20-Apr-2021 Time : 11:16:05 am
 */
public class ReverseBetween extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode root = scannerInput();
		int left = sc.nextInt();
		int right = sc.nextInt();
		root = reverseBetween(root, left, right);
		printLinkedList(root);

	}

	/**
	 * @param root
	 * @return
	 */
	public static ListNode reverseBetween(ListNode head, int left, int right) {
		// checkl for base cases
		if (head == null || head.next == null) {
			return head;
		}

		ListNode temp = head;
		ListNode before = head;
		ListNode after = head;
		ListNode reverseList = null;
		// Traverse thorugh the list and store the list seperately
		// for reversePart
		while (temp != null) {
			if (temp.val != left) {
				before = before.next;
			} else {
				reverseList = before.next;
				before.next = null;
				while (temp != null && temp.val != right) {
					temp = temp.next;
				}
				after = temp.next;
				temp.next = null;
				//if(before != null) before.next = null;
				break;
			}
			temp = temp.next;
		}
		ListNode reversedHead = reverse(reverseList);
		before.next = reversedHead;
		while (before.next != null) {
			before = before.next;
		}
		before.next = after;
		return head;
	}

	private static ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode reversedHead = reverse(head.next);
		ListNode temp = head.next;
		head.next = null;
		temp.next = head;
		return reversedHead;
	}

}
