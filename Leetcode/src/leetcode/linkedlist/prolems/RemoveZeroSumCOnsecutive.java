/**
 * 
 */
package leetcode.linkedlist.prolems;

/**
 * @author Hardik
 *
 *         Date : 19-Apr-2021 Time : 10:55:14 pm
 */
public class RemoveZeroSumCOnsecutive extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode root = scannerInput();
		ListNode ans = removeZeroSumSublists(root);
		printLinkedList(ans);

	}

	/**
	 * @param root
	 * @return
	 */
	private static ListNode removeZeroSumSublists(ListNode head) {
		ListNode Head = new ListNode(0);
		Head.next = head;
		ListNode cur = Head;
		while (cur != null) {
			int sum = 0;
			while (head != null) {
				sum += head.val;
				if (sum == 0) {
					cur.next = head.next;
				}
				head = head.next;
			}
			cur = cur.next;
			if (cur != null) {
				head = cur.next;
			}
		}
		return Head.next;
	}

}
