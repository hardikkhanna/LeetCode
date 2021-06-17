/**
 * 
 */
package leetcode.priorityQueue.problems;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : 08-May-2021 Time : 6:05:35 pm
 */
public class checkMaxHeap extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = get1DArray();
		Boolean ans = checkMaxHeapFunc(arr);
		System.out.println(ans);
	}

	/**
	 * @param arr
	 * @return
	 */
	private static Boolean checkMaxHeapFunc(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (2 * i + 2 < arr.length) {
				if (arr[i] < arr[(2 * i) + 1] || arr[i] < arr[(2 * i) + 2]) {
					return false;
				}
			} else if (arr[i] > arr[(i - 1) / 2]) {
				return false;
			}

		}
		return true;
	}

}
