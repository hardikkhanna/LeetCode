/**
 * 
 */
package leetcode.array.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hardik
 *
 *         Date : 21-May-2021 Time : 5:37:34 pm
 */
public class PrintSeries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 5;
		int k = 2;
		List<Integer> list = printSeries(n, k);
		System.out.println(list);

	}

	/**
	 * @param n
	 * @param k
	 * @return
	 */
	public static List<Integer> printSeries(int n, int k) {
		// Write your code here!
		List<Integer> arr = new ArrayList<Integer>();
		printSeries(n, k, arr);
		return arr;
	}

	private static void printSeries(int n, int k, List<Integer> list) {
		if (n <= 0) {
			list.add(n);
			return;
		}

		list.add(n);
		printSeries(n - k, k, list);
		list.add(n);
	}

}
