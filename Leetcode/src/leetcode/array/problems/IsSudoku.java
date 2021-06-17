/**
 * 
 */
package leetcode.array.problems;

/**
 * @author Hardik
 *
 *         Date : 22-May-2021 Time : 6:34:41 pm
 */
public class IsSudoku extends ScannerInput {

	/**
	 * @param args;
	 * 
	 */
	public static void main(String[] args) {

		int[][] matrix = get2DArray();
		Boolean ans = isValidSudoku(matrix, 0, 0);
		System.out.println(ans);

	}

	/**
	 * @param matrix
	 * @param length
	 * @param length2
	 * @return
	 */
	private static Boolean isValidSudoku(int[][] board, int i, int j) {

		if (i == board.length) {
			return true;
		}

		// iterate over each element in level order
		if (j == board.length) {
			i = i + 1;
			j = 0;
		}

		if (board[i][j] != 0) {
			return isValidSudoku(board, i, j + 1);
		}

		for (int digit = 1; digit <= board.length; digit++) {
			board[i][j] = digit;
			if (isValidOption(board, i, j, digit)) {
				if (isValidSudoku(board, i, j + 1))
					return true;
			}
			board[i][j] = 0;
		}
		return false;
	}

	static private boolean isValidOption(int matrix[][], int i, int j, int digit) {
		int N = matrix.length;
		int[][] row = new int[N][N + 1];
		int[][] column = new int[N][N + 1];
		int[][][] subMatrix = new int[3][3][N + 1];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (matrix[r][c] == 0) {
					continue;
				}
				row[r][matrix[r][c]] += 1;
				column[c][matrix[r][c]] += 1;
				subMatrix[r / 3][c / 3][matrix[r][c]] += 1;
				if (subMatrix[r / 3][c / 3][matrix[r][c]] > 1 || column[c][matrix[r][c]] > 1
						|| row[r][matrix[r][c]] > 1) {
					return false;
				}
			}
		}
		return true;
	}
}
