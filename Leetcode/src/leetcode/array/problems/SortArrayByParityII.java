/**
 * 
 */
package leetcode.array.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NIPC-43
 *
 *         Date : Jan 31, 2021 Time : 3:53:18 PM
 */
public class SortArrayByParityII extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = get1DArray();
		A = sortArrayByParityII(A);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}

	/**
	 * @param a
	 * @return
	 */
	private static int[] sortArrayByParityII(int[] A) {
		List<Integer> even = new ArrayList<>();
		List<Integer> odd = new ArrayList<>();
		int j = 0, k = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				even.add(A[i]);
			} else {
				odd.add(A[i]);
			}
		}
		for (int i = 0; i < A.length; i++) {
			if (i % 2 == 0) {
				A[i] = even.get(j++);
			} else {
				A[i] = odd.get(k++);
			}
		}
		return A;
	}

}
