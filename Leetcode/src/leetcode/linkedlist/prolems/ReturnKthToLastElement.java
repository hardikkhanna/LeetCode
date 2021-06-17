/**
 * 
 */
package leetcode.linkedlist.prolems;

/**
 * @author Hardik
 *
 * Date : 17-Apr-2021
 * Time : 10:59:18 am
 */
public class ReturnKthToLastElement extends ScannerInput{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = scannerInput();
		int k = sc.nextInt();
		KthToLastNode(head,k);
		//System.out.println(element);

	}

	/**
	 * @param head
	 * @return
	 */
	private static int KthToLastNode(ListNode head, int k) {
		if(head == null || k <= 0) return 0;
		int index = KthToLastNode(head.next, k) + 1;
		if(index == k) System.out.println(head.val);
		return index;
	}

}
