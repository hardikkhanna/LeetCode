/**
 * 
 */
package leetcode.linkedlist.prolems;

/**
 * @author Hardik
 *
 *         Date : 15-Apr-2021 Time : 4:31:40 pm
 */
public class DetectAndFindNodesInLoop extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode root = scannerInput();
		int data = detectAndFindLoop(root);
		System.out.println(data);

	}

	/**
	 * @param root
	 * @return
	 */
	private static int detectAndFindLoop(ListNode head) {
		// Base case
		if (head == null)
			return 0;

		ListNode fast = head;
		ListNode slow = fast;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				ListNode ptr = head;
				while (ptr != slow) {
					ptr = ptr.next;
					slow = slow.next;
				}
				return ptr.val;
			}
		}
		return 0;
	}

}
