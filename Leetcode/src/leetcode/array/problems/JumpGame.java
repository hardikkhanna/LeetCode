/**
 * 
 */
package leetcode.array.problems;

/**
 * @author Hardik
 *
 *         Date : 05-May-2021 Time : 2:37:27 pm
 */
public class JumpGame extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = get1DArray();

		int minJumps = jump(nums);

		System.out.println(minJumps);

	}

	public static int jump(int[] nums) {

		return jump(nums, 0);
	}

	private static int jump(int[] nums, int start) {
		// check for base case
		if (nums == null || nums.length == 0 || start >= nums.length - 1)
			return 0;

		// if my start index if greater than equal to
		// last index then I have to take only one jump
		if (nums[start] >= nums.length - start - 1) {
			//System.out.println(nums[start]);
			return 1;
		}

		// If start index is less then we have to check the next greater element
		// for the range start - start + maximum number of jumps from start
		int index = 0;
		int max = nums[start];
		for (int i = start + 1; i <= start + nums[start] && i < nums.length; i++) {
			if (max < nums[i]) {
				max = nums[i];
				index = i;
			}
		}
		if (index == 0)
			index = start + nums[start];
		return 1 + jump(nums, index);
	}

}
