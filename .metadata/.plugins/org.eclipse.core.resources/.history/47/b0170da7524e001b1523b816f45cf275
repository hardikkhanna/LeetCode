/**
 * 
 */
package leetcode.linkedlist.prolems;

/**
 * @author NIPC-43
 *
 *         Date : Jan 4, 2021 Time : 10:27:13 AM
 */
public class MiddleOfLinkedList extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = scannerInput();
		head = middleNode(head);
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	/**
	 * @param head
	 * @return
	 */
	private static ListNode middleNode(ListNode head) {
		if (head.next == null)
			return head;
		int count = 0;
		ListNode temp = head;
		while (temp.next != null) {
			count++;
			temp = temp.next;
		}
		temp = head;
		count = count % 2 == 0 ? count / 2 - 1 : count / 2;
		while (temp.next != null) {
			if (count-- != 0) {
				temp = temp.next;
				continue;
			}
			return temp.next;
		}
		return temp;
	}

}
