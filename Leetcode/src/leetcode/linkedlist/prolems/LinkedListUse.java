/**
 * 
 */
package leetcode.linkedlist.prolems;

/**
 * @author Hardik
 *
 *         Date : 19-Apr-2021 Time : 8:43:18 pm
 */
public class LinkedListUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DesignLinkedList list = new DesignLinkedList();
		list.addAtHead(0);
		list.addAtIndex(1, 4);
		list.addAtTail(8);
		list.addAtHead(0);
		list.addAtIndex(0, 1);
		list.addAtTail(0);
		list.addAtTail(0);

	}
}
