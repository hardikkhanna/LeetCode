/**
 * 
 */
package leetcode.binarytrees.problems;

import leetcode.linkedlist.prolems.ListNode;
import leetcode.linkedlist.prolems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : Mar 19, 2021 Time : 1:03:21 PM
 */

//Linked List Node
class LNode {
	int data;
	LNode next;

	LNode(int d) {
		data = d;
		next = null;
	}
}

//Tree Node
class TNode {
	int data;
	TNode left, right;

	TNode(int x) {
		data = x;
		left = right = null;
	}

}

public class SortedLinkedListToBST extends ScannerInput {

	/**
	 * @param args
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		ListNode head = scannerInput();
		BinaryTreeNode<Integer> root = sortedListToBST(head);
		BinaryTreeUse bt = new BinaryTreeUse();
		bt.printTreeLevelWise(root);
	}

	/**
	 * @param head
	 * @return
	 */
	private static BinaryTreeNode<Integer> sortedListToBST(ListNode head) {

		int n = countNodes(head);
		return sortedListToBST(head, n);

	}

	/**
	 * @param head
	 * @return
	 */
	private static int countNodes(ListNode head) {
		int count = 0;
		if (head == null)
			return 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

	/**
	 * @param head
	 * @param n
	 * @return
	 */
	private static BinaryTreeNode<Integer> sortedListToBST(ListNode head, int n) {

		if (n <= 0 || head == null)
			return null;

		int mid = n / 2;

		ListNode temp = head;
		while (temp != null) {
			if (mid-- <= 0)
				break;
			temp = temp.next;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(temp.val);

		BinaryTreeNode<Integer> left = sortedListToBST(head, n / 2);

		BinaryTreeNode<Integer> right = sortedListToBST(temp.next, n - n / 2 - 1);
		root.left = left;
		root.right = right;
		return root;
	}

}
