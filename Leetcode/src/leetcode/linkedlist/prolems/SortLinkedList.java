/**
 * 
 */
package leetcode.linkedlist.prolems;

/**
 * @author Hardik
 *
 *         Date : 19-Apr-2021 Time : 4:52:52 pm
 */
public class SortLinkedList extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode root1 = scannerInput();
//		ListNode root2 = scannerInput();
//		merge(root1,root2);
		ListNode sortedList = sortList(root1);
		while (sortedList != null) {
			System.out.print(sortedList.val + " ");
			sortedList = sortedList.next;
		}
	}

	/**
	 * @param root
	 * @return
	 */
	private static ListNode sortList(ListNode root) {
		if (root == null || root.next == null)
			return root;

		ListNode fast = root;
		ListNode slow = root;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode secondHalf = slow.next;
		slow.next = null;
		ListNode firstHalf = sortList(root);
		secondHalf = sortList(secondHalf);
		return merge(firstHalf, secondHalf);
	}

	/**
	 * @param firstHalf
	 * @param secondHalf
	 * @return
	 */
	private static ListNode merge(ListNode firstHalf, ListNode secondHalf) {
		if(firstHalf == null) return secondHalf;
		if(secondHalf == null) return firstHalf;
		ListNode ansHead = new ListNode(0);
		ListNode ansTail = ansHead;
		while(firstHalf != null && secondHalf != null) {
			if(firstHalf.val < secondHalf.val) {
				ansTail.next = new ListNode(firstHalf.val);
				firstHalf = firstHalf.next;
			}else {
				ansTail.next = new ListNode(secondHalf.val);
				secondHalf = secondHalf.next;
			}
			ansTail = ansTail.next;
		}
		if(firstHalf != null) {
			ansTail.next = firstHalf;
		}
		if(secondHalf != null) {
			ansTail.next = secondHalf;
		}
		return ansHead.next;
	}

}
