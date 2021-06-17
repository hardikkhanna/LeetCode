/**
 * 
 */
package leetcode.linkedlist.prolems;

/**
 * @author Hardik
 *
 *         Date : Jan 6, 2021 Time : 4:56:01 PM
 */
public class RemoveLinkedListElelements extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = scannerInput();
		int n = sc.nextInt();
		head = removeElements(head, n);
		printLinkedList(head);

	}

	/**
	 * @param head
	 * @param n
	 * @return
	 */
	private static ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;

		while (cur.next != null) {
			if (cur.next.val == val) {
				cur.next = cur.next.next;
			} else
				cur = cur.next;
		}
		return dummy.next;
	}

}
