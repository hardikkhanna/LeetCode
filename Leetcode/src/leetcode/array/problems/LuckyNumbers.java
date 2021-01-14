/**
 * 
 */
package leetcode.array.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Hardik
 *
 *         Date : Jan 14, 2021 Time : 3:12:22 PM
 */
public class LuckyNumbers extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = get2DArray();
		List<Integer> ans = luckyNumbers(matrix);
		System.out.println(ans);

	}

	/**
	 * @param matrix
	 * @return
	 */
	private static List<Integer> luckyNumbers(int[][] matrix) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < matrix.length; i++) {
			int[] arr = matrix[i].clone();
			int min = Arrays.stream(arr).min().getAsInt();
			map.put(min, 1);
		}

		for (int i = 0; i < matrix[0].length; i++) {
			int maxm = matrix[0][i];
			for (int j = 1; j < matrix.length; j++)
				if (matrix[j][i] > maxm)
					maxm = matrix[j][i];

			if (map.containsKey(maxm))
				map.put(maxm, map.get(maxm) + 1);
			else
				map.put(maxm, 1);
		}
		// Stream<Entry<Integer, Integer>> ans = map.entrySet().stream().filter(m ->
		// m.getValue().intValue() > 1);
		List<Integer> ans = new ArrayList<Integer>();
		for (int i : map.keySet()) {
			if (map.get(i) > 1) {
				ans.add(i);
			}
		}
		return ans;
	}

}
