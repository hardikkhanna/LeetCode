/**
 * 
 */
package leetcode.array.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Hardik
 *
 *         Date : Jan 24, 2021 Time : 8:50:57 AM
 */
public class SortTheMatrixDiagonally extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] arr = get2DArray();
		arr = diagonalSort(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * @param arr
	 * @return
	 */
	private static int[][] diagonalSort(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				List<Integer> list = new ArrayList<Integer>();
				int k = j;
				for (int m = i; m < mat.length && k < mat[0].length; m++) {
					list.add(mat[m][k++]);
				}
				Collections.sort(list);
				k = j;
				for (int m = 0; m < list.size(); m++) {
					mat[m + i][k++] = list.get(m);
				}
			}
		}
		return mat;
	}

}
