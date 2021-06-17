/**
 * 
 */
package leetcode.linkedlist.prolems;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Hardik
 *
 *         Date : Jan 6, 2021 Time : 1:21:15 PM
 */
public class LinkedListCycle extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode list = scannerInput();
		Boolean ans = hasCycle(list);
		System.out.println(ans);
	}

	/**
	 * @param head
	 */
	private static boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode walker = head;
		ListNode runner = head;
		while (runner.next != null && runner.next.next != null) {
			walker = walker.next;
			runner = runner.next.next;
			if (walker == runner)
				return true;
		}
		return false;

	}

}
