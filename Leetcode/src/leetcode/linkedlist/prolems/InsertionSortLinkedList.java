/**
 * 
 */
package leetcode.linkedlist.prolems;

/**
 * @author Hardik
 *
 * Date : 19-Apr-2021
 * Time : 7:06:25 pm
 */
public class InsertionSortLinkedList extends ScannerInput{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode root = scannerInput();
		insertionSort(root);
		printLinkedList(root);

	}

	/**
	 * @param root
	 */
	private static void insertionSort(ListNode root) {
		if(root == null) {
			return;
		}
		
		ListNode temp = root.next;
		
		while(temp != null) {
			ListNode curr = root;
			while(curr != temp) {
				if(curr.val > temp.val) {
					int tempVar = curr.val;
					curr.val = temp.val;
					temp.val = tempVar;
				}
				curr = curr.next;
			}
			temp = temp.next;
		}
		
	}

}
