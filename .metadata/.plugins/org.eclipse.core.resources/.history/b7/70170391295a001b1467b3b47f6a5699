/**
 * 
 */
package leetcode.linkedlist.prolems;

/**
 * @author Hardik
 *
 *         Date : Jan 4, 2021 Time : 9:41:43 AM
 */
public class ConvertBinaryNumberInListToInteger extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = scannerInput();
		int ans = getDecimalValue(head);
		System.out.println(ans);
	}

	public static int getDecimalValue(ListNode head) {
		int num = head.val;

		while (head.next != null) {

			num = num * 2 + head.next.val;
			head = head.next;
		}
		return num;
	}

}
