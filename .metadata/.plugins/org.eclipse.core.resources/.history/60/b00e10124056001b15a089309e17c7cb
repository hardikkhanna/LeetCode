/**
 * 
 */
package leetcode.array.problems;

import java.util.HashMap;

/**
 * @author Hardik
 *
 *         Date : Jan 14, 2021 Time : 11:58:46 AM
 */
public class MinimumCostToMoveChips extends ScannerInput {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] position = get1DArray();
		int ans = minCostToMoveChips(position);
		System.out.println(ans);

	}

	/**
	 * @param position
	 * @return
	 */
	private static int minCostToMoveChips(int[] position) {
		int even_cnt = 0;
		int odd_cnt = 0;
		for (int i : position) {
			if (i % 2 == 0) {
				even_cnt++;
			} else {
				odd_cnt++;
			}
		}
		return Math.min(odd_cnt, even_cnt);
	}

}
