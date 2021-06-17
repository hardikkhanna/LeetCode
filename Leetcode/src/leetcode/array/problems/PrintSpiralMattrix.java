/**
 * 
 */
package leetcode.array.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author Hardik
 *
 *         Date : 21-May-2021 Time : 12:27:14 pm
 */
public class PrintSpiralMattrix extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[][] matrix = get2DArray();
		List<Integer> list = spiral(matrix, matrix.length, matrix[0].length);
		System.out.println(list);
		HashMap<Integer, Integer> map = new HashMap<>();
		List<Integer> list2 = new ArrayList<>(map.values());
	}

	/**
	 * @param matrix
	 * @param length
	 * @param length2
	 * @return
	 */
	private static List<Integer> spiral(int[][] matrix, int n, int m) {
		List<Integer> list = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0)
			return list;

		int row = 0;
		int col = 0;

		while (row <= n / 2) {

			int i = col;
			for (; i < m - col - 1; i++) {
				list.add(matrix[row][i]); // 1 2 3 4
			}

			int j = row;
			for (; j < n - row - 1; j++) {
				list.add(matrix[j][i]); // 8 12 16
			}

			// i = i - 1;
			for (; i > col; i--) {
				list.add(matrix[j][i]);
			}

			// j = j - 1;
			for (; j > row; j--) {
				list.add(matrix[j][i]);
			}
			row++;
			col++;
		}
		return list;
	}

}
