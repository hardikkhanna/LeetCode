/**
 * 
 */
package leetcode.array.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 5, 2021 Time : 12:16:21 PM
 */
public class ScannerInput extends FastReader {
	protected static FastReader sc = new FastReader();
	static int length;
	static int row;
	static int col;

	/**
	 * @param args
	 */
	public static int[] get1DArray() {

		length = sc.nextInt();
		int[] arr = new int[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		return arr;
	}

	public static int[][] get2DArray() {

		row = sc.nextInt();
		col = sc.nextInt();
		int[][] arr = new int[row][col];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		return arr;
	}

	public static String[][] get2DStringArray() {

		row = sc.nextInt();
		col = sc.nextInt();
		String[][] arr = new String[row][col];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < col; j++) {
				arr[i][j] = sc.nextLine();
			}
		}
		return arr;
	}

	public static int[][] getDynamic2D() {

		int n = sc.nextInt();

		int[][] arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			int m = sc.nextInt();
			arr[i] = new int[m];
			if (m == 1) {
				arr[i][0] = sc.nextInt();
			} else {
				for (int j = 0; j < m; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
		}
		return arr;
	}

	public static String[] get1DStringArray() {

		length = sc.nextInt();
		String[] str = new String[length];
		for (int i = 0; i < length; i++) {
			str[i] = sc.next();
		}
		return str;
	}

	public static char[] get1DcharArray() {
		length = sc.nextInt();
		char[] ch = new char[length];
		for (int i = 0; i < length; i++) {
			ch[i] = sc.next().charAt(0);
		}
		return ch;
	}

	public static char[][] get2DcharArray() {
		row = sc.nextInt();
		col = sc.nextInt();
		char[][] ch = new char[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				ch[i][j] = sc.next().charAt(0);
			}
		}
		return ch;
	}

}
