/**
 * 
 */
package leetcode.linkedlist.prolems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Hardik
 *
 *         Date : Jan 7, 2021 Time : 1:04:40 PM
 */
public class LinkedListComponents extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = scannerInput();
		int n = sc.nextInt();
		int[] G = new int[n];
		for (int i = 0; i < G.length; i++) {
			G[i] = sc.nextInt();
		}
		int ans = numComponents(head, G);
		System.out.println(ans);
	}

	/**
	 * @param head
	 * @param g
	 * @return
	 */
	private static int numComponents(ListNode head, int[] g) {
		Set<Integer> setG = new HashSet<>();
		for (int i : g)
			setG.add(i);
		int res = 0;
		while (head != null) {
			if (setG.contains(head.val) && (head.next == null || !setG.contains(head.next.val)))
				res++;
			head = head.next;
		}
		return res;
	}

}
