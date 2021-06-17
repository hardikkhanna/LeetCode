/**
 * 
 */
package leetcode.weeklycontest.problems;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : 06-Jun-2021 Time : 8:44:56 am
 */
public class Contest244 extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] nums = get1DArray();
		int ans = reductionOperations(nums);
		System.out.println(ans);

	}

	public static int reductionOperations(int[] nums) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x, y) -> (y - x));
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i : nums) {
			pq.offer(i);
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}

		if (map.size() == 1)
			return 0;
		int ans = 0;
		while (map.size() > 1) {
			int largest = pq.poll();
			int largestOcc = map.get(largest);
			while (!pq.isEmpty() && pq.peek() == largest)
				pq.poll();
			int nextLargest = pq.peek();
			int secondLargestOcc = map.get(nextLargest);
			ans += largestOcc;
			map.remove(largest);
			map.put(nextLargest, secondLargestOcc + largestOcc);
		}

		return ans;
	}

}
