/**
 * 
 */
package leetcode.linkedlist.prolems;

/**
 * @author Hardik
 *
 *         Date : Jan 6, 2021 Time : 12:18:54 PM
 */
public class IntersectionOfTwoLinkedList extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode list1 = scannerInput();
		ListNode list2 = scannerInput();
		ListNode ans = getIntersectionNode(list1, list2);
		while (ans != null) {
			System.out.print(ans.val + " ");
			ans = ans.next;
		}

	}

	/**
	 * @param list1
	 * @param list2
	 * @return
	 */
	private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;

		ListNode a = headA;
		ListNode b = headB;

		// if a & b have different len, then we will stop the loop after second
		// iteration
		while (a != b) {
			// for the end of first iteration, we just reset the pointer to the head of
			// another linkedlist
			a = a == null ? headB : a.next;
			b = b == null ? headA : b.next;
		}
		return a;
	}

}
