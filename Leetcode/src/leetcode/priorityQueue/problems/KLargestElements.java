/**
 * 
 */
package leetcode.priorityQueue.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 08-May-2021 Time : 5:08:05 pm
 */
public class KLargestElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		ArrayList<Integer> list = kLargest(input, k);
		System.out.println(list);
		sc.close();
	}

	/**
	 * @param input
	 * @param k
	 * @return
	 */
	private static ArrayList<Integer> kLargest(int[] input, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int i = 0;
		for (; i < k; i++) {
			pq.add(input[i]);
		}

		for (; i < input.length; i++) {
			if (input[i] > pq.peek()) {
				pq.remove();
				pq.add(input[i]);
			}
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(pq);
		Collections.sort(list);
		return list;
	}

}
