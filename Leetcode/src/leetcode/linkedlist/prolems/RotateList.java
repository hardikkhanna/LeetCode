/**
 * 
 */
package leetcode.linkedlist.prolems;

/**
 * @author Hardik
 *
 *         Date : 21-Apr-2021 Time : 12:16:53 pm
 */
public class RotateList extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = scannerInput();
		int k = sc.nextInt();
		head = rotateList(head, k);
		printLinkedList(head);
	}

	/**
	 * @param head
	 * @return
	 */
	private static ListNode rotateList(ListNode head, int k) {
		// check for base cases
		if (head == null || head.next == null)
			return head;
		int length = getSize(head);
		k = k % length;
		if (k == 0)
			return head;
		ListNode temp = head;
		ListNode tail = null;
		ListNode newHead = null;
		if (k != 0 && length != k) {
			while (temp.next != null) {
				if (length - k == 1) {
					tail = temp;
					newHead = temp.next;
				}

				length--;
				temp = temp.next;
			}
			temp.next = head;
			head = newHead;
			tail.next = null;
		}
		return head;
	}

	private static int getSize(ListNode head) {
		if (head == null)
			return 0;
		ListNode temp = head;
		int count = 0;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
	}

}
