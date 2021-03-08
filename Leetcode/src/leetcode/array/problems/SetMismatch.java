/**
 * 
 */
package leetcode.array.problems;

/**
 * @author NIPC-43
 *
 *         Date : Mar 7, 2021 Time : 7:41:09 AM
 */
public class SetMismatch extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] ch = new char[2];
		int[] errorNums = get1DArray();
		int[] ans = findErrorNums(errorNums);
		System.out.print(ans[0] + " " + ans[1]);

	}

	/**
	 * @param errorNums
	 * @return
	 */
	private static int[] findErrorNums(int[] nums) {
		int[] helper = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			helper[nums[i]]++;
		}
		int[] ans = new int[2];
		for (int i = 1; i < helper.length; i++) {
			if (helper[i] == 0) {
				ans[1] = i;
			} else if (helper[i] > 1) {
				ans[0] = i;
			}
		}
		return ans;
	}

}
