/**
 * 
 */
package leetcode.array.problems;

/**
 * @author Hardik
 *
 *         Date : 28-May-2021 Time : 7:20:19 pm
 */
public class SortByKthBit extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] nums = get1DArray();
		int k = sc.nextInt();
		nums = sortArrayByKthBit(nums, k);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}

	}

	/**
	 * @param nums
	 * @param k
	 * @return
	 */
	private static int[] sortArrayByKthBit(int[] nums, int k) {

		int[] arr = new int[nums.length];
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (!isValid(nums[i], k)) {
				arr[index++] = nums[i];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (isValid(nums[i], k)) {
				arr[index++] = nums[i];
			}
		}
		return arr;
	}

	/**
	 * @param nums
	 * @param i
	 * @param j
	 */
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	/**
	 * @param k
	 * @param i
	 * @return
	 */
	private static boolean isValid(int num, int k) {

//		String binary = Long.toBinaryString(num & 0xffffffffL | 0x100000000L).substring(1);
//
//		int index = binary.length() - k;
//
//		return binary.charAt(index) == '1';

		String binary = Integer.toBinaryString(num);
		if (k > binary.length())
			return true;
		return binary.charAt(binary.length() - k) == 1;
	}

}
