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
	static ListNode addedListHead;
	static int carry;

	public static void main(String[] args) {
		ListNode l1 = scannerInput();
		ListNode l2 = scannerInput();
		// Approach 1
		// l1 = addTwoNumbers(l1, l2);
		// Approach 2
		l1 = addTwoNumbers2(l1, l2);
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
	private static ListNode addTwoNumbers2(ListNode h1, ListNode h2) {
		ListNode temp1 = h1;
		ListNode temp2 = h2;
		int length1 = getSize(h1);
		int length2 = getSize(h2);
		int difference = Math.abs(length1 - length2);
		if (difference > 0) {
			if (length1 > length2) {
				while (temp1 != null && difference-- > 1) {
					temp1 = temp1.next;
				}
				addSameLength(temp1.next, h2);
				temp1.next = null;
				temp2 = h1;
				propagateCarry(temp2);
				temp1.next = addedListHead;
				if (carry > 0) {
					h1 = addNewNode(h1);
				}
				return h1;
			} else {
				while (temp2 != null && difference-- > 1) {
					temp2 = temp2.next;
				}
				addSameLength(temp1, temp2.next);
				temp2.next = null;
				temp1 = h2;
				propagateCarry(temp1);
				temp2.next = addedListHead;
				if (carry > 0) {
					h2 = addNewNode(h2);
				}
				return h2;
			}
		} else {
			addSameLength(h1, h2);
			if (carry > 0)
				return addNewNode(addedListHead);
		}
		return addedListHead;
	}

	/**
	 * @param h1
	 * @return
	 */
	private static ListNode addNewNode(ListNode h1) {
		if (h1 == null)
			return null;
		ListNode newNode = new ListNode(carry);
		newNode.next = h1;
		return newNode;

	}

	/**
	 * @param temp1
	 */
	private static void propagateCarry(ListNode temp1) {
		if (temp1 == null)
			return;
		propagateCarry(temp1.next);
		int sum = temp1.val + carry;
		temp1.val = sum % 10;
		carry = sum / 10;
	}

	/**
	 * @param next
	 * @param h2
	 */
	private static void addSameLength(ListNode h1, ListNode h2) {
		if (h1 == null || h2 == null)
			return;
		addSameLength(h1.next, h2.next);
		int sum = (carry + h1.val + h2.val) % 10;
		carry = (carry + h1.val + h2.val) / 10;
		if (addedListHead == null)
			addedListHead = new ListNode(sum);
		else {
			ListNode newNode = new ListNode(sum);
			newNode.next = addedListHead;
			addedListHead = newNode;
		}
	}

	/**
	 * @param h1
	 * @return
	 */
	private static int getSize(ListNode h1) {
		ListNode temp = h1;
		int count = 0;
		while (temp != null) {
			temp = temp.next;
			count++;
		}
		return count;
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
