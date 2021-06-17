/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.util.HashMap;

/**
 * @author Hardik
 *
 *         Date : 16-May-2021 Time : 8:51:32 am
 */
public class FindSumPairs {

	HashMap<Integer, Integer> map2;
	int[] nums2;
	int[] nums1;

	public FindSumPairs(int[] nums1, int[] nums2) {
		this.nums2 = nums2;
		this.nums1 = nums1;
		map2 = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums2.length; i++) {
			if (map2.containsKey(nums2[i])) {
				map2.put(nums2[i], map2.get(nums2[i]) + 1);
			} else {
				map2.put(nums2[i], 1);
			}
		}
	}

	public void add(int index, int val) {
		if (map2.containsKey(nums2[index])) {
			int ele = map2.get(nums2[index]);
			if (ele == 1)
				map2.remove(nums2[index]);
			else if (map2.containsKey(nums2[index])) {
				map2.put(nums2[index], map2.get(nums2[index]) - 1);
			}

			if (map2.containsKey(nums2[index] + val))
				map2.put(nums2[index] + val, map2.get(nums2[index] + val) + 1);
			else
				map2.put(nums2[index] + val, 1);
		} else
			map2.put(nums2[index] + val, 1);
	}

	public int count(int tot) {
		int count = 0;
		for (int i = 0; i < nums1.length; i++) {
			if (map2.containsKey(tot - nums1[i])) {
				count += map2.get(tot - nums1[i]);
			}
		}
		return count;
	}
}
