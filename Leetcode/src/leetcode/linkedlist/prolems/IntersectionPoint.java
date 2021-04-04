/**
 * 
 */
package leetcode.linkedlist.prolems;

/**
 * @author Hardik
 *
 *         Date : Mar 28, 2021 Time : 2:29:58 PM
 */
public class IntersectionPoint extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = scannerInput();
		ListNode head1 = scannerInput();
		int point = changeList(head, head1);
		System.out.println(point);
	}

	/**
	 * @param head
	 * @param head1
	 * @return
	 */
	private static int changeList(ListNode h1, ListNode h2) {
		if (h1 == null || h2 == null) {
			return -1;
		}
		int length1 = getSize(h1);
		int length2 = getSize(h2);
		int difference = Math.abs(length1 - length2);
		if (difference > 0) {
			if (length1 > length2) {
				while (h1 != null && difference-- > 0) {
					h1 = h1.next;
				}
			} else {
				while (h2 != null && difference-- > 0) {
					h2 = h2.next;
				}
			}
		}
		return intersectionPoint(h1, h2);
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
	 * @param h1
	 * @param h2
	 * @return
	 */
	private static int intersectionPoint(ListNode h1, ListNode h2) {
		if (h1 == null || h2 == null)
			return -1;
		int ans = intersectionPoint(h1.next, h2.next);
		if (h1.val == (h2.val))
			return h1.val;
		return ans;
	}

}
