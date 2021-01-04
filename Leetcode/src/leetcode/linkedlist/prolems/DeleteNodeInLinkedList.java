/**
 * 
 */
package leetcode.linkedlist.prolems;

/**
 * @author Hardik
 *
 *         Date : Jan 4, 2021 Time : 10:43:48 AM
 */
public class DeleteNodeInLinkedList extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = scannerInput();
		head = reverseList(head);
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}

	}

	/**
	 * @param head
	 * @return
	 */
	private static ListNode reverseList(ListNode head) {
		ListNode newHead = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}

}
