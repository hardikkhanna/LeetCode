/**
 * 
 */
package leetcode.array.problems;

import java.util.ArrayList;

/**
 * @author Hardik
 *
 *         Date : 27-May-2021 Time : 2:32:56 am
 */
public class PartitionInKSubsetsOfEqualSum extends ScannerInput {

	private static ArrayList<ArrayList<Integer>> temp;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] nums = get1DArray();
		int k = sc.nextInt();
		Boolean ans = partiton(nums, k);
		System.out.println(ans);
	}

	/**
	 * @param nums
	 * @param k
	 * @return
	 */
	private static boolean partiton(int[] nums, int k) {
		if (k > nums.length)
			return false;
		temp = new ArrayList<>();
		for (int i = 0; i < k; i++)
			temp.add(new ArrayList<Integer>());
		int[] subsetSum = new int[k];
		return parition(nums, k, 0, 0, subsetSum);

	}

	/**
	 * @param nums
	 * @param k
	 * @param i
	 * @return
	 */
	private static boolean parition(int[] nums, int k, int start, int sub, int[] subsetSum) {

		if (start == nums.length) {
			if (sub == k) {
				Boolean flag = true;;
				for(int i = 0; i < subsetSum.length - 1; i++) {
					if(subsetSum[i] != subsetSum[i + 1]) {
						flag = false;
						break;
					}
				}
				return flag;
			}
			return false;
		}

		Boolean ans = false;
		for (int i = 0; i < k; i++) {
			if (temp.get(i).size() > 0) {
				temp.get(i).add(nums[start]);
				subsetSum[i] += nums[start];
				ans = ans || parition(nums, k, start + 1, sub, subsetSum);
				subsetSum[i] -= nums[start];
				temp.get(i).remove(temp.get(i).size() - 1);
			} else {
				temp.get(i).add(nums[start]);
				subsetSum[i] += nums[start];
				ans = ans || parition(nums, k, start + 1, sub + 1, subsetSum);
				subsetSum[i] -= nums[start];
				temp.get(i).remove(temp.get(i).size() - 1);
				break;
			}
		}

		return ans;
	}

}
