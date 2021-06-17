package oops.concept;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class CornersTraversal {

	/**
	 * @param args
	 */

	static StringBuilder builder;
	static List<List<Integer>> ans;
	static boolean[][] visited;
	static List<Integer> pathSoFar;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();
		int startPoint = sc.nextInt();

		int[][] matrix = new int[row][col];
		int val = 1;
		int startRow = 0;
		int startCol = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (val == startPoint) {
					startRow = i;
					startCol = j;
				}
				matrix[i][j] = val++;
			}
		}
		HashMap<Integer, List<Integer>> paths = new HashMap<>();
		for (int i = 0; i < row * col; i++) {
			int key = sc.nextInt();
			List<Integer> value = new ArrayList<Integer>();
			for (int j = 0; j < 8; j++) {
				value.add(sc.nextInt());
			}
			paths.put(key, value);
		}
		visited = new boolean[row][col];
		computePaths(matrix, startPoint, startRow, startCol, paths);
		for (List<Integer> l : ans) {
			for (int i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	/**
	 * @param matrix
	 * @param startCol
	 * @param startRow
	 * @param startPoint
	 * @param paths
	 */
	private static void computePaths(int[][] matrix, int startPoint, int startRow, int startCol,
			HashMap<Integer, List<Integer>> paths) {

		builder = new StringBuilder();
		ans = new ArrayList<>();
		for (int i = 0; i < 4; i++)
			ans.add(new ArrayList<Integer>());
		pathSoFar = new ArrayList<Integer>();
		backTracking(matrix, startPoint, startRow, startCol, paths, 0);

	}

	/**
	 * @param matrix
	 * @param startPoint
	 * @param startRow
	 * @param startCol
	 * @param paths
	 */
	private static void backTracking(int[][] matrix, int startPoint, int startRow, int startCol,
			HashMap<Integer, List<Integer>> paths, int pathStart) {

		// Reached at 1st Corner
		if ((startRow == 0 && startCol == 0)) {
			pathSoFar.add(matrix[startRow][startCol]);
			addData(0);
			pathSoFar.remove(pathSoFar.size() - 1);
			return;

		}
		// Reached Corner 2nd Corner
		if (startRow == 0 && startCol == matrix[0].length - 1) {
			pathSoFar.add(matrix[startRow][startCol]);
			addData(1);
			pathSoFar.remove(pathSoFar.size() - 1);
			return;
		}
		// Reached 3rd Corner
		if (startRow == matrix.length - 1 && startCol == 0) {
			pathSoFar.add(matrix[startRow][startCol]);
			addData(2);
			pathSoFar.remove(pathSoFar.size() - 1);
			return;
		}
		// Reached 4th Corner
		if (startRow == matrix.length - 1 && startCol == matrix[0].length - 1) {
			pathSoFar.add(matrix[startRow][startCol]);
			addData(3);
			// System.out.println(pathSoFar + " Sum 2 = " + sum2 + " Sum 1 = " + sum1);
			pathSoFar.remove(pathSoFar.size() - 1);

			return;
		}
		if (startRow < 0 || startCol < 0 || startRow >= matrix.length || startCol >= matrix[0].length
				|| visited[startRow][startCol] == true) {
			return;
		}
		visited[startRow][startCol] = true;
		for (int i = 0; i <= 7; i++) {
			if (paths.get(matrix[startRow][startCol]).get(i) == 1) {
				int currPos = matrix[startRow][startCol];
				if (i == 0) {
					// Moving Upwards
					pathSoFar.add(currPos);
					backTracking(matrix, startPoint, startRow - 1, startCol, paths, pathStart + 1);
					pathSoFar.remove(pathSoFar.size() - 1);
				} else if (i == 1) {
					// Moving Upward Right Diagonal
					pathSoFar.add(currPos);
					backTracking(matrix, startPoint, startRow - 1, startCol + 1, paths, pathStart + 1);
					pathSoFar.remove(pathSoFar.size() - 1);
				} else if (i == 2) {
					// Moving Right
					pathSoFar.add(currPos);
					backTracking(matrix, startPoint, startRow, startCol + 1, paths, pathStart + 1);
					pathSoFar.remove(pathSoFar.size() - 1);
				} else if (i == 3) {
					// Moving Right Lower Diagonal
					pathSoFar.add(currPos);
					backTracking(matrix, startPoint, startRow + 1, startCol + 1, paths, pathStart + 1);
					pathSoFar.remove(pathSoFar.size() - 1);
				} else if (i == 4) {
					// Moving Lower
					pathSoFar.add(currPos);
					backTracking(matrix, startPoint, startRow + 1, startCol, paths, pathStart + 1);
					pathSoFar.remove(pathSoFar.size() - 1);
				} else if (i == 5) {
					// Moving Lower Left
					pathSoFar.add(currPos);
					backTracking(matrix, startPoint, startRow + 1, startCol - 1, paths, pathStart + 1);
					pathSoFar.remove(pathSoFar.size() - 1);
				} else if (i == 6) {
					// Moving Left
					pathSoFar.add(currPos);
					backTracking(matrix, startPoint, startRow, startCol - 1, paths, pathStart + 1);
					pathSoFar.remove(pathSoFar.size() - 1);
				} else if (i == 7) {
					// Moving Left Upward Diagonal
					pathSoFar.add(currPos);
					backTracking(matrix, startPoint, startRow - 1, startCol - 1, paths, pathStart + 1);
					pathSoFar.remove(pathSoFar.size() - 1);
				}
			}
		}
		visited[startRow][startCol] = false;

	}

	/**
	 * 
	 */
	private static void addData(int index) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int sum1 = 0;
		int sum2 = 0;
		for (int i : pathSoFar) {
			list.add(i);
			sum1 += i;
		}

		if (ans.get(index).size() == 0) {
			ans.set(index, list);
		} else {
			sum2 = ans.get(index).stream().mapToInt(Integer::intValue).sum();
			if (sum2 > sum1) {
				ans.set(index, list);
			}
		}
	}

}