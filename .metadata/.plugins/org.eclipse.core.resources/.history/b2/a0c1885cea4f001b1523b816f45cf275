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
		int[] freq = new int[1001];
		ListNode temp = head;
		while (temp != null) {
			freq[temp.val]++;
			temp = temp.next;
		}
		temp = head;
		while (temp.next != null) {
			if (freq[temp.val] > 1) {
				temp.val = temp.next.val;
				temp.next = temp.next.next;
				continue;
			}
			temp = temp.next;
		}
		temp = head;
		return temp;
	}

}
