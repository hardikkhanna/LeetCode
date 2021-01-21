/**
 * 
 */
package leetcode.linkedlist.prolems;

/**
 * @author Hardik
 *
 *         Date : Jan 19, 2021 Time : 12:29:32 PM
 */
public class AddTwoNumbers extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode l1 = scannerInput();
		ListNode l2 = scannerInput();
		l1 = addTwoNumbers(l1, l2);
		while (l1 != null) {
			System.out.print(l1.val + " ");
			l1 = l1.next;
		}
	}

	/**
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode reverseList(ListNode head) {
		ListNode last = null;
		while (head != null) {
			ListNode tmp = head.next;
			head.next = last;
			last = head;
			head = tmp;
		}
		return last;
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		l1 = reverseList(l1);
		l2 = reverseList(l2);

		ListNode head = null;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int x1 = l1 != null ? l1.val : 0;
			int x2 = l2 != null ? l2.val : 0;

			int val = (carry + x1 + x2) % 10;
			carry = (carry + x1 + x2) / 10;

			ListNode curr = new ListNode(val);
			curr.next = head;
			head = curr;

			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
		}

		if (carry != 0) {
			ListNode curr = new ListNode(carry);
			curr.next = head;
			head = curr;
		}

		return head;
	}

}
