/**
 * 
 */
package leetcode.array.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 10, 2021 Time : 8:38:55 AM
 */
public class MinimumHammingDistance extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] source = get1DArray();
		int[] target = get1DArray();
		int[][] allowedswaps = get2DArray();
		int ans = minimumHammingDistance(source, target, allowedswaps);
		System.out.println(ans);

	}

	/**
	 * @param source
	 * @param target
	 * @param allowedswaps
	 * @return
	 */
	private static int minimumHammingDistance(int[] source, int[] target, int[][] allowedswaps) {
		for (int i = 0; i < allowedswaps.length; i++) {
			int value1 = source[allowedswaps[i][0]];
			int value2 = source[allowedswaps[i][1]];
			source[allowedswaps[i][0]] = value2;
			source[allowedswaps[i][1]] = value1;
		}
		int count = 0;
		for (int i = 0; i < source.length; i++) {
			if (source[i] != target[i])
				count++;
		}
		return count;
	}

}
