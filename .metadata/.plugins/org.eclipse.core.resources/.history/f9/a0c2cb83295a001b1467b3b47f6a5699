/**
 * 
 */
package leetcode.array.problems;

import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : Jan 3, 2021 Time : 1:27:10 PM
 */
public class SortArrayByParity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		arr = sortArrayByParity(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		sc.close();
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int[] sortArrayByParity(int[] A) {
		for (int i = 0, j = 0; j < A.length; j++)
			if (A[j] % 2 == 0) {
				int tmp = A[i];
				A[i++] = A[j];
				A[j] = tmp;
			}
		return A;
	}

}
