/**
 * 
 */
package leetcode.linkedlist.prolems;

/**
 * @author Hardik
 *
 *         Date : 21-Apr-2021 Time : 11:34:31 am
 */
public class RemoveDuplicateElements extends ScannerInput {

	public static void main(String[] args) {
		ListNode head = scannerInput();
		ListNode ans = removeDuplicates(head);
		printLinkedList(ans);
	}

	/**
	 * @param head
	 * @return
	 */
	private static ListNode removeDuplicates(ListNode head) {
		// check for base cases
		if (head == null || head.next == null)
			return head;

		ListNode temp = head;
		ListNode prev = null;

		while (temp != null && temp.next != null) {
			if (temp.val == temp.next.val) {
				while (temp.next != null && temp.val == temp.next.val)
					temp = temp.next;
				if (prev == null)
					head = temp.next;
				else
					prev.next = temp.next;
				temp = temp.next;
				continue;
			}
			prev = temp;
			temp = temp.next;
		}
		return head;
	}

}
