/**
 * 
 */
package leetcode.linkedlist.prolems;

/**
 * @author Hardik
 *
 *         Date : Jan 4, 2021 Time : 12:34:09 PM
 */
public class DeleteDuplicates extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = scannerInput();
		head = deleteDuplicates(head);
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}

	}

	/**
	 * @param head
	 * @return
	 */
	private static ListNode deleteDuplicates(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			if (temp.next != null && temp.val == temp.next.val) {
				temp.val = temp.next.val;
				temp.next = temp.next.next;
			} else {
				temp = temp.next;
			}
		}
		return temp = head;
	}

}
