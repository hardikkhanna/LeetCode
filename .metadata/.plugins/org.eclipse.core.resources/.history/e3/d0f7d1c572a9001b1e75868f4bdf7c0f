/**
 * 
 */
package leetcode.array.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Hardik
 *
 *         Date : Jan 24, 2021 Time : 9:02:57 PM
 */
public class MajorityElement extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = get1DArray();
		List<Integer> list = majorityElement(nums);
		list.forEach(i -> System.out.print(list.get(i) + " "));
	}

	/**
	 * @param nums
	 * @return
	 */
	private static List<Integer> majorityElement(int[] a) {
		int x = a.length / 3;

		HashMap<Integer, Integer> y = new HashMap<>();

		for (int i = 0; i < a.length; i++) {
			if (!y.containsKey(a[i]))
				y.put(a[i], 1);
			else {
				int count = y.get(a[i]);
				y.put(a[i], count + 1);
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		for (Map.Entry m : y.entrySet()) {
			Integer temp = (Integer) m.getValue();
			if (temp > x)
				list.add((Integer) m.getKey());
		}
		return list;
	}

}
