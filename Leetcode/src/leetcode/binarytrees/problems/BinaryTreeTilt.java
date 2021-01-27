/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 26, 2021 Time : 1:15:42 PM
 */
public class BinaryTreeTilt extends BinaryTreeUse {

	private static int sum = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int ans = findTilt(root);
		System.out.println(ans);

	}

	/**
	 * @param root
	 * @return
	 */
	private static int findTilt(BinaryTreeNode<Integer> root) {
		helper(root);
		return sum;
	}

	/**
	 * @param root
	 * @param sum
	 * @return
	 */
	private static int helper(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return root.data;
		}
		int leftSum = helper(root.left);
		int rightSum = helper(root.right);
		sum += Math.abs(leftSum - rightSum);
		return root.data + leftSum + rightSum;
	}

}
