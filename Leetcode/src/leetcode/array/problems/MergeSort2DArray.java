/**
 * 
 */
package leetcode.array.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class InputReader {
	BufferedReader br;
	StringTokenizer st;

	public InputReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}

public class MergeSort2DArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		InputReader sc = new InputReader();
		int row = sc.nextInt();
		int col = sc.nextInt();
		int[][] matrix = new int[row][col];
		int[][] helper = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		mergeSort(matrix, helper, row, col, 0, 0);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
		}
	}

	/**
	 * @param matrix
	 * @param helper
	 * @param row
	 * @param col
	 * @param start
	 * @param end
	 */
	private static void mergeSort(int[][] matrix, int[][] helper, int row, int col, int start, int end) {

		int smallColumn = (col / 2) + (col % 2);
		int smallRow = (row / 2) + (row % 2);
		if (row == 1 && col == 1)
			return;

		if (row == 1) {
			mergeSort(matrix, helper, row, smallColumn, start, end);
			mergeSort(matrix, helper, row, col - smallColumn, start, end + smallColumn);
			sortByRow(matrix, helper, row, row, smallColumn, col - smallColumn, start, start, end,
					end + smallColumn);
			return;
		}

		if (col == 1) {
			mergeSort(matrix, helper, smallRow, col, start, end);
			mergeSort(matrix, helper, row - smallRow, col, start + smallRow, end);
			sortByColumn(matrix, helper, smallRow, row - smallRow, col, col, start, start + smallRow, end, end);
			return;
		}

		mergeSort(matrix, helper, smallRow, smallColumn, start, end);
		mergeSort(matrix, helper, smallRow, col - smallColumn, start, end + smallColumn);
		mergeSort(matrix, helper, row - smallRow, smallColumn, start + smallRow, end);
		mergeSort(matrix, helper, row - smallRow, col - smallColumn, start + smallRow, end + smallColumn);
		sortByRow(matrix, helper, smallRow, smallRow, smallColumn, col - smallColumn, start, start, end,
				end + smallColumn);
		sortByRow(matrix, helper, row - smallRow, row - smallRow, smallColumn, col - smallColumn,
				start + smallRow, start + smallRow, end, end + smallColumn);
		sortByColumn(matrix, helper, smallRow, row - smallRow, col, col, start, start + smallRow, end, end);
	}

	/**
	 * @param matrix
	 * @param helper
	 * @param smallRow
	 * @param smallColumn
	 * @param start
	 * @param end
	 */
	private static void sortByColumn(int[][] matrix, int[][] helper, int smallRow, int smallRow2, int smallColumn1,
			int smallColumn2, int start1, int start2, int end1, int end2) {

		int j = end1;
		while (j < smallColumn1 + end1) {
			int L1 = start1, L2 = start2, i = start1;

			for (; L1 - start1 < smallRow && L2 - start2 < smallRow2; i++) {
				if (matrix[L1][j] < matrix[L2][j])
					helper[i][j] = matrix[L1++][j];
				else
					helper[i][j] = matrix[L2++][j];
			}

			if (L1 - start1 < smallRow) {
				for (; L1 - start1 < smallRow; L1++, i++)
					helper[i][j] = matrix[L1][j];
			} else {
				for (; L2 - start2 < smallRow2; L2++, i++)
					helper[i][j] = matrix[L2][j];
			}
			j++;
		}

		copyArrayFromColumn(matrix, helper, start1, smallRow, smallRow2, end1, smallColumn1);

	}

	/**
	 * @param matrix
	 * @param helper
	 * @param start1
	 * @param smallRow
	 * @param smallRow2
	 * @param end1
	 * @param smallColumn1
	 */
	private static void copyArrayFromColumn(int[][] matrix, int[][] helper, int start1, int smallRow, int smallRow2,
			int end1, int smallColumn1) {

		for (int i = start1; i < smallRow + smallRow2 + start1; i++)
			for (int j = end1; j < smallColumn1 + end1; j++)
				matrix[i][j] = helper[i][j];

	}

	/**
	 * @param matrix
	 * @param helper
	 * @param smallRow
	 * @param smallColumn
	 * @param start
	 * @param end
	 */
	private static void sortByRow(int[][] matrix, int[][] helper, int smallRow, int smallRow2, int smallColumn1,
			int smallColumn2, int start1, int start2, int end1, int end2) {

		int i = start1;
		while (i < smallRow + start1) {
			int L1 = end1, L2 = end2, j = end1;

			for (; L1 - end1 < smallColumn1 && L2 - end2 < smallColumn2; j++) {
				if (matrix[i][L1] < matrix[i][L2])
					helper[i][j] = matrix[i][L1++];
				else
					helper[i][j] = matrix[i][L2++];
			}

			if (L1 - end1 < smallColumn1) {
				for (; L1 - end1 < smallColumn1; L1++, j++)
					helper[i][j] = matrix[i][L1];
			} else {
				for (; L2 - end2 < smallColumn2; L2++, j++)
					helper[i][j] = matrix[i][L2];
			}
			i++;
		}

		copyArrayFromRow(matrix, helper, start1, smallRow, end1, smallColumn1, smallColumn2);

	}

	/**
	 * @param matrix
	 * @param helper
	 * @param start1
	 * @param smallRow
	 * @param end1
	 * @param smallColumn1
	 * @param smallColumn2
	 */
	private static void copyArrayFromRow(int[][] matrix, int[][] helper, int start1, int smallRow, int end1,
			int smallColumn1, int smallColumn2) {

		for (int i = start1; i < smallRow + start1; i++)
			for (int j = end1; j < smallColumn1 + smallColumn2 + end1; j++)
				matrix[i][j] = helper[i][j];

	}

}
