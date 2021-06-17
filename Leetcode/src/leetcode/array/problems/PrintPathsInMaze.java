/**
 * 
 */
package leetcode.array.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Hardik
 * @Question You are given a 2-D matrix consisting of 0’s and 1’s with ‘N’ rows
 *           and ‘N’ columns, you are supposed to find all paths from the cell
 *           (0,0) (top-left cell) to the cell (N-1, N-1)(bottom-right cell).
 *           All cells with value 0 are blocked and cannot be travelled through
 *           while all cells with value 1 are open. If you are currently at cell
 *           (x,y) then you can move to (x+1,y)(denoted by ‘D’), (x-1,y)(denoted
 *           by ‘U’), (x,y+1)(denoted by ‘R’), (x,y-1)(denoted by ‘L’) in one
 *           move. You cannot move out of the grid.
 * 
 *           Sample Input : 3 3 1 0 1 1 1 1 1 0 0 1 0 1 1 1 1 1 1 1 Sample
 *           Output :- DDRR DDRR RRDD
 */
public class PrintPathsInMaze extends ScannerInput {

	static List<String> output;
	static StringBuilder sb = new StringBuilder();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int[][] maze = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
			List<String> list = printPaths(maze);
			System.out.println(list);
		}
		sc.close();
	}

	/**
	 * @param maze
	 * @return
	 */
	private static List<String> printPaths(int[][] maze) {

		output = new ArrayList<>();
		printPaths(maze, 0, 0);
		return output;
	}

	/**
	 * @param maze
	 * @param row
	 * @param col
	 */
	private static void printPaths(int[][] maze, int row, int col) {

		if (maze[row][col] == 0) {
			return;
		}
		if (row == maze.length - 1 && col == maze.length - 1) {
			output.add(sb.toString());
			return;
		}

		maze[row][col] = 0;
		if (row + 1 < maze.length) {
			sb.append("D");
			printPaths(maze, row + 1, col);
			sb.deleteCharAt(sb.length() - 1);
		}

		if (col + 1 < maze.length) {
			sb.append("R");
			printPaths(maze, row, col + 1);
			sb.deleteCharAt(sb.length() - 1);
		}

		if (row - 1 >= 0) {
			sb.append("U");
			printPaths(maze, row - 1, col);
			sb.deleteCharAt(sb.length() - 1);
		}

		if (col - 1 >= 0) {
			sb.append("L");
			printPaths(maze, row, col - 1);
			sb.deleteCharAt(sb.length() - 1);
		}
		maze[row][col] = 1;
	}

}
