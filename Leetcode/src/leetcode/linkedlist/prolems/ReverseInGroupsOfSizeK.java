/**
 * 
 */
package leetcode.linkedlist.prolems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 15-Apr-2021 Time : 4:39:52 pm
 */
class Pair {
	ListNode reverseHead;
	ListNode reverseTail;
	
	Pair(ListNode reverseHead, ListNode reverseTail){
		this.reverseHead = reverseHead;
		this.reverseTail = reverseTail;
	}
}
public class ReverseInGroupsOfSizeK extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ListNode root = scannerInput();
		int k = sc.nextInt();
		ListNode reverseList = reverseInKGroups(root, k);
		printLinkedList(reverseList);
		sc.close();
	}

	/**
	 * @param root
	 * @param k
	 * @return
	 */
	private static ListNode reverseInKGroups(ListNode root, int k) {
		if (k <= 0 || root == null)
			return root;

		ListNode temp = root;
		int t = k;
		while (temp != null && t-- > 1) {
			temp = temp.next;
		}
		if(temp == null || temp.next == null || t>=1) return reverseList(root);
		ListNode remainingList = temp.next;
		temp.next = null;
		ListNode reversedHead = reverseList(root);
		temp = reversedHead;
		while (temp.next != null)
			temp = temp.next;
		temp.next = reverseInKGroups(remainingList, k);
		return reversedHead;
	}

	/**
	 * @param temp
	 * @return
	 */
	private static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode reverseHead = reverseList(head.next);
		ListNode temp = head.next;
		head.next = null;
		temp.next = head;
		return reverseHead;
	}
}
