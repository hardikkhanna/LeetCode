/**
 * 
 */
package leetcode.weeklycontest.problems;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : 16-May-2021 Time : 8:52:12 am
 */
public class WeeklyContest241 extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums1 = get1DArray();
		int[] num2 = get1DArray();
		FindSumPairs findSumPairs = new FindSumPairs(nums1, num2);
		System.out.println(findSumPairs.count(7));
		findSumPairs.add(3, 2); // now nums2 = [1,4,5,4,5,4]
		System.out.println(findSumPairs.count(8));
		System.out.println(findSumPairs.count(4));
		findSumPairs.add(0, 1); // now nums2 = [2,4,5,4,5,4]
		findSumPairs.add(1, 1); // now nums2 = [2,5,5,4,5,4]
		System.out.println(findSumPairs.count(7));
		
		String str = "abcd";
		

	}

}
