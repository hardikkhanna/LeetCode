/**
 * 
 */
package leetcode.priorityQueue.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Hardik
 *
 *         Date : 07-May-2021 Time : 3:31:57 pm
 */
public class PriorityQueueUse {

	/**
	 * @param args
	 * @throws PrioritQueueException
	 */
	public static void main(String[] args) throws PrioritQueueException {

		PriorityQueue<Integer> min = new PriorityQueue<Integer>((x, y) -> x - y);
		int[] arr = new int[] { 5, 9, 8, 12, 11, 4, 3, 2, 1 };

		for (int i = 0; i < arr.length; i++) {
			min.add(arr[i]);
		}

		while (!min.isEmpty()) {
			System.out.print(min.remove() + " ");
		}

		// To create a max PriorityQueue
		// Option 1
		PriorityQueue<Integer> op1 = new PriorityQueue<>(Collections.reverseOrder());

		// Option 2 using Comparator
		MaxComparator maxComparator = new MaxComparator();
		PriorityQueue<Integer> op2 = new PriorityQueue<Integer>(maxComparator);

		// option 3 extension of option2 with lambda JAVA 8
		PriorityQueue<Integer> op3 = new PriorityQueue<Integer>((x, y) -> Integer.compare(y, x));

		// Priority Queue of Strings based on the length of the String;

		String[] arr1 = { "the", "king", "is", "main", "player", "of", "chess" };
		PriorityQueue<String> pq = new PriorityQueue<String>((str1, str2) -> str2.length() - str1.length());
		for (String str : arr1) {
			pq.add(str);
		}
		pq.remove("is");
		ArrayList<String> list = new ArrayList<>();
		while (!pq.isEmpty()) {
			list.add(pq.remove());
		}
		System.out.println(list);
		
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		
	}

}

class MaxComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		if (o1 < o2)
			return 1;
		else if (o1 > o2)
			return -1;
		return 0;
	}

}
