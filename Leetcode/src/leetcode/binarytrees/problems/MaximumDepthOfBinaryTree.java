/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author NIPC-43
 *
 *         Date : Jan 16, 2021 Time : 8:22:12 AM
 */
public class MaximumDepthOfBinaryTree extends BinaryTreeUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int ans = maxDepth(root);
		System.out.println(ans);

	}

	public static int maxDepth(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return left < right ? right + 1 : left + 1;
	}

}
