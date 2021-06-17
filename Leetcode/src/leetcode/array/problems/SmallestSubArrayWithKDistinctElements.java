/**
 * 
 */
package leetcode.array.problems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Hardik
 *
 *         Date : 19-May-2021 Time : 3:12:46 pm
 */
public class SmallestSubArrayWithKDistinctElements extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = get1DArray();
		int k = sc.nextInt();
		smallestSubarrayWithKDistinct(arr, k);
		sc.close();
	}

	/**
	 * @param arr
	 * @param k
	 */
	private static void smallestSubarrayWithKDistinct(int[] arr, int k) {

		if (arr == null || arr.length == 0)
			return;

		int i = 0;
		int start = 0;
		Set<Integer> st = new HashSet<Integer>();
		while (i < arr.length) {
			while (!st.isEmpty() && st.contains(arr[i])) {
				st.remove(arr[start]);
				start += 1;
			}

			st.add(arr[i]);
			if (st.size() == k) {
				System.out.println(start + " " + i);
				return;
			}
			i++;
		}
		System.out.println(-1);
	}

}
