/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 27, 2021 Time : 5:58:04 PM
 */
public class BalancedBinaryTree extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		Boolean ans = isBalanced(root);
		System.out.println(ans);

	}

	private static Boolean isBalanced(BinaryTreeNode<Integer> root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Math.abs(leftHeight - rightHeight) <= 1;

	}

	/**
	 * @param left
	 * @return
	 */
	private static int height(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}

}
