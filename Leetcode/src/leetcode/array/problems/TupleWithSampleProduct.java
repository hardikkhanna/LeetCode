/**
 * 
 */
package leetcode.array.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hardik
 *
 *         Date : Jan 17, 2021 Time : 8:25:06 AM
 */
public class TupleWithSampleProduct extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = get1DArray();
		int ans = tupleSameProduct(arr);
		System.out.println(ans);

	}

	/**
	 * @param arr
	 * @return
	 */
	private static int tupleSameProduct(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length - 1; ++i) {
			for (int j = i + 1; j < nums.length; ++j) {
				int prod = nums[i] * nums[j];
				map.put(prod, map.getOrDefault(prod, 0) + 1);
			}
		}

		int res = 0;
		for (int key : map.keySet()) {
			int val = map.get(key);
			if (val > 1) {
				int combinations = (val * (val - 1)) / 2;
				res += combinations * 8;
			}

		}
		return res;
	}

}
