/**
 * 
 */
package leetcode.array.problems;

/**
 * @author Hardik
 *
 *         Date : 22-May-2021 Time : 2:26:45 am
 */
public class RatInAMaze extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] maze = get2DArray();
		int[][] copy = new int[maze.length][maze[0].length];
		printWays(maze, 0, 0, copy);

	}

	/**
	 * @param maze
	 * @param col
	 * @param row
	 * @param copy
	 */
	private static void printWays(int[][] maze, int row, int col, int[][] copy) {

		if (row == maze.length - 1 && col == maze.length - 1) {
			copy[row][col] = 1;
			printArray(copy);
			copy[row][col] = 0;
			return;
		}

		if (maze[row][col] == 0)
			return;

		else {
			copy[row][col] = 1;
			// Move in upward direction
			if (row - 1 >= 0 && copy[row - 1][col] != 1) {
				printWays(maze, row - 1, col, copy);
				// copy[row][col] = 0;
			}
			// move in downward direction
			if (row + 1 < maze.length && copy[row + 1][col] != 1) {
				printWays(maze, row + 1, col, copy);
				// copy[row][col] = 0;
			}

			// move in left direction
			if (col - 1 >= 0 && copy[row][col - 1] != 1) {
				printWays(maze, row, col - 1, copy);
				// copy[row][col] = 0;
			}

			// move in right direction
			if (col + 1 < maze[row].length && copy[row][col + 1] != 1) {
				printWays(maze, row, col + 1, copy);
				// copy[row][col] = 0;
			}
			copy[row][col] = 0;

		}
		return;
	}

	/**
	 * @param maze
	 */
	private static void printArray(int[][] maze) {

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				System.out.print(maze[i][j] + " ");
			}
		}
		System.out.println();
	}

}
