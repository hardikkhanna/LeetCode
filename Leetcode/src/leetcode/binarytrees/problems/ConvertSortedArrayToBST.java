/**
 * 
 */
package leetcode.binarytrees.problems;

import leetcode.array.problems.ScannerInput;

/**
 * @author Hardik
 *
 *         Date : Jan 22, 2021 Time : 11:43:13 AM
 */
public class ConvertSortedArrayToBST extends ScannerInput {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = get1DArray();
		BinaryTreeNode<Integer> root = sortedArrayToBST(arr);
		BinaryTreeUse.printTreeLevelWise(root);
	}

	/**
	 * @param arr
	 * @return
	 */
	public static BinaryTreeNode<Integer> sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		return getTreeNode(nums, 0, nums.length - 1);
	}

	private static BinaryTreeNode<Integer> getTreeNode(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int middle = start + (end - start) / 2;
		BinaryTreeNode<Integer> n = new BinaryTreeNode<Integer>(nums[middle]);
		n.left = getTreeNode(nums, start, middle - 1);
		n.right = getTreeNode(nums, middle + 1, end);
		return n;
	}

}
