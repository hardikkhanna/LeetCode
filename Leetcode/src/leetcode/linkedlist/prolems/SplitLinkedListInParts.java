/**
 * 
 */
package leetcode.linkedlist.prolems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 19-Apr-2021 Time : 4:20:19 pm
 */
public class SplitLinkedListInParts extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ListNode root = scannerInput();
		int k = sc.nextInt();
		ListNode[] list = splitListToParts(root, k);
		for (int i = 0; i < list.length; i++) {
			ListNode head = list[i];
			while (head != null) {
				System.out.print(head.val + " ");
				head = head.next;
			}
		}
		sc.close();
	}

	private static ListNode[] splitListToParts(ListNode root, int k) {
		if (root == null || k == 0)
			return null;

		int length = getSize(root);

		// create ListNode array to store the partitions
		ListNode[] list = new ListNode[k];

		int width = length / k;
		int rem = length % k;

		// ListNode curr = root;
		for (int i = 0; i < k; ++i) {
			ListNode head = new ListNode(0);
			ListNode tail = head;
			int toAdd = i < rem ? 1 : 0;
			for (int j = 0; j < width + toAdd && root != null; j++) {
				tail.next = new ListNode(root.val);
				root = root.next;
			}
			list[i] = head.next;

		}
		return list;
	}

	/**
	 * @param root
	 * @return
	 */
	private static int getSize(ListNode root) {
		if (root == null)
			return 0;
		ListNode temp = root;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
}
