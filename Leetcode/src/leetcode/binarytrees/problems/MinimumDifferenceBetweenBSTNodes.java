/**
 * 
 */
package leetcode.binarytrees.problems;

/**
 * @author NIPC-43
 *
 *         Date : Jan 25, 2021 Time : 9:16:46 PM
 */
public class MinimumDifferenceBetweenBSTNodes extends BinaryTreeUse {

	private static int minDiff = Integer.MAX_VALUE;

	private static BinaryTreeNode<Integer> prev;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int ans = minDiffInBST(root);
		System.out.println(ans);
	}

	/**
	 * @param root
	 * @return
	 */
	private static int minDiffInBST(BinaryTreeNode<Integer> root) {
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
