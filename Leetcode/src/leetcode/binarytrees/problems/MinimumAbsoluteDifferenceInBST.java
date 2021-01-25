/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author Hardik
 *
 *         Date : Jan 25, 2021 Time : 9:00:11 PM
 */
public class MinimumAbsoluteDifferenceInBST extends BinaryTreeUse {

	private static int minDiff = Integer.MAX_VALUE;

	static BinaryTreeNode<Integer> prev;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int ans = getMinimumDifference(root);
		System.out.println(ans);

	}

	/**
	 * @param root
	 * @return
	 */
	public static int getMinimumDifference(BinaryTreeNode<Integer> root) {
		inorder(root);
		return minDiff;
	}

	public static void inorder(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		inorder(root.left);
		if (prev != null)
			minDiff = Math.min(minDiff, root.data - prev.data);
		prev = root;
		inorder(root.right);
	}
}
