/** s
 * 
 */
package leetcode.weeklycontest.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : 29-May-2021 Time : 8:18:33 pm
 */
public class BiWeeklyContest53 extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		int[] nums1 = get1DArray();
//		int[] nums2 = get1DArray();
//		int ans = minimumXORSum(nums1, nums2);
//		System.out.println(ans);
		int[][] grid = get2DArray();
		int[] ans = getBiggestThree(grid);
		System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);

	}

	/**
	 * @param grid
	 * @return
	 */
	private static int[] getBiggestThree(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int sum = 0;
		int[] ans = new int[3];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 1; j < grid.length - 1; j++) {
				sum = grid[i][j];
				int rightrow = i + 1, rightcol = j + 1, leftrow = i + 1, leftcol = j - 1;
				for (; rightrow < m && rightcol < n && leftcol >= 0 && leftrow >= 0
						&& m - rightrow >= rightrow - i; rightrow++, rightcol++, leftrow++, leftcol--) {
					sum += grid[rightrow][rightcol];
					sum += grid[leftrow][leftcol];
				}
				for (; rightcol != leftcol; rightrow--, rightcol++, leftrow--, leftcol++) {
					sum += grid[rightrow][rightcol];
					sum += grid[leftrow][leftcol];
				}
				if (sum != grid[i][j])
					sum += grid[rightrow][rightcol];
			}
			if (pq.size() > 3) {
				pq.add(sum);
			} else {
				if (pq.peek() < sum) {
					pq.remove();
					pq.add(sum);
				}
			}
		}
		for (int i = 0; i < ans.length; i++) {
			ans[i] = pq.remove();
		}
		int temp = ans[0];
		ans[0] = ans[2];
		ans[2] = temp;
		// Arrays.sort(ans, Collections.reverseOrder());
		return ans;
	}

	private static int minimumXORSum(int[] nums1, int[] nums2) {
		int ans = 0;
		int[][] arr = new int[nums1.length][nums2.length];
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				arr[i][j] = nums1[i] ^ nums2[j];
			}
		}

		for (int j = 0; j < arr.length - 1; j++) {
			int index = j;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < arr.length; i++) {
				if (min > arr[i][j]) {
					min = arr[i][j];
					index = i;
				}
			}
			swap(nums2, j, index);
		}
		for (int i = 0; i < nums1.length; i++) {
			ans += nums1[i] ^ nums2[i];
		}
		return ans;

	}

	/**
	 * @param nums2
	 * @param i
	 * @param j
	 */
	private static void swap(int[] nums2, int i, int j) {

		int temp = nums2[i];
		nums2[i] = nums2[j];
		nums2[j] = temp;

	}

}
