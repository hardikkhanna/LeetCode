/**
 * 
 */
package leetcode.linkedlist.prolems;

import java.util.HashSet;

/**
 * @author Hardik
 *
 *         Date : 16-Apr-2021 Time : 10:06:30 pm
 */
public class RemoveDuplicatesInUnsortedList extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode head = scannerInput();
		removeDuplicates(head);
		printLinkedList(head);

	}

	/**
	 * @param head
	 */
	private static void removeDuplicates(ListNode head) {
		// Base Case
		if (head == null)
			return;
		// Approach 1 : Time Complexity : O(n) where n is the number of nodes in linked list
		// Space Complexity : O(n) 
		
		
		
		// Create a set to store the elemnets of list
		HashSet<Integer> set = new HashSet<Integer>();
		ListNode temp = head.next;
		ListNode prev = head;
		set.add(prev.val);
		while (temp != null) {
			if (set.contains(temp.val)) {
				prev.next = temp.next;
				temp.next = null;
				temp = prev.next;
			} else {
				set.add(temp.val);
				temp = temp.next;
				prev = prev.next;
			}
			
		}

	}
}
